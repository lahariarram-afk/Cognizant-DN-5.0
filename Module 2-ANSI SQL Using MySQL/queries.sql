-- 1. User Upcoming Events 
-- Show a list of all upcoming events a user is registered for in their city, sorted by date. 

select u.user_id,u.full_name,e.title 
from Users u
inner join Registrations r on r.user_id=Users.user_id
inner join Events e on e.event_id=Registrations.event_id
where e.status='upcoming' and e.city=u.city
order by e.start_date asc;

-- 2. Top Rated Events 
-- Identify events with the highest average rating, considering only those that have received at 
-- least 10 feedback submissions. 

select event_id,avg(rating) as avgRating,count(*) from feedback 
group by event_id
having count(*)>=10
order by avgRating desc;

-- 3. Inactive Users 
-- Retrieve users who have not registered for any events in the last 90 days. 

select user_id,full_name,registration_date
from Users
left join Registrations on Users.user_id=Registrations.user_id
and Registrations.registration_date >= CURDATE() - INTERVAL 90 DAY
where Registrations.user_id is null;

-- 4. Peak Session Hours 
-- Count how many sessions are scheduled between 10 AM to 12 PM for each event. 

select event_id,count(*) as session_count
from Sessions
where cast(start_time as time )between '10:00:00' and '12:00:00' 
group by event_id;

-- 5. Most Active Cities 
-- List the top 5 cities with the highest number of distinct user registrations. 

select Users.city ,count(distinct Registrations.user_id) as regcount
from Users
join Registrations on Users.user_id=Registrations.user_id
group by city
order by regcount desc
LIMIT 5;

-- 6. Event Resource Summary 
-- Generate a report showing the number of resources (PDFs, images, links) uploaded for each 
-- event. 

select event_id,
    sum(case when resource_type='pdf' then 1 else 0 end) as pdf_count,
    sum(case when resource_type='image' then 1 else 0 end) as image_count,
    sum(case when resource_type='link' then 1 else 0 end) as link_count,
    count(*) as total_resources
from Resources
group by event_id;

-- 7. Low Feedback Alerts 
-- List all users who gave feedback with a rating less than 3, along with their comments and 
-- associated event names.

select f.user_id,u.full_name,f.comments,f.event_id,e.title 
from Feedback as f
join Users as u on f.user_id=u.user_id
join Events as e on f.event_id=e.event_id
where f.rating <3;

-- 8. Sessions per Upcoming Event 
-- Display all upcoming events with the count of sessions scheduled for them.

select e.event_id,e.title,e.status,count(*)
from Events as e
join Sessions as s on e.event_id=s.event_id
where e.status='upcoming'
group by e.event_id,e.title,e.status;

-- 9. Organizer Event Summary 
-- For each event organizer, show the number of events created and their current status 
-- (upcoming, completed, cancelled). 

select organizer_id,status,count(*)
from Events
group by organizer_id,status
order by organizer_id,status;

-- 10. Feedback Gap 
-- Identify events that had registrations but received no feedback at all. 

select e.event_id,e.title
from Events as e
left join Feedback as f on e.event_id=f.event_id
join Registrations as r on e.event_id=r.event_id
group by e.event_id,e.title
having count(distinct r.registration_id)>0 and count(distinct f.feedback_id)=0;

-- 11. Daily New User Count 
-- Find the number of users who registered each day in the last 7 days.

select registration_date,count(*) as user_count
from Users
where registration_date >= CURDATE() - INTERVAL 7 DAY
group by registration_date
order by registration_date asc;

-- 12. Event with Maximum Sessions 
-- List the event(s) with the highest number of sessions. 

select e.event_id,e.title,count(s.session_id) as session_count
from Events as e
join Sessions as s on e.event_id=s.event_id
group by e.event_id,e.title
having count(s.session_id)=(
    SELECT MAX(session_count)
    FROM (
        SELECT COUNT(*) AS session_count
        FROM Sessions
        GROUP BY event_id
    ) t
);

-- 13. Average Rating per City 
-- Calculate the average feedback rating of events conducted in each city. 

select e.city,avg(f.rating) as avg_rating
from Events as e
join Feedback as f on e.event_id = f.event_id
group by e.city;

-- --14. Most Registered Events 
-- List top 3 events based on the total number of user registrations. 

select e.event_id,e.title,count(r.registration_id) as reg_count
from Events as e
join Registrations as r on e.event_id = r.event_id
group by e.event_id,e.title
order by reg_count desc
limit 3;

-- 15. Event Session Time Conflict 
-- Identify overlapping sessions within the same event (i.e., session start and end times that 
-- conflict). 

select s1.event_id,
    s1.session_id as session1,
    s2.session_id as session2,
    s1.title as session1_t,
    s2.title as session2_t
from Sessions as s1
join Sessions s2 on s1.event_id = s2.event_id
    and s1.session_id <s2.session_id
    and s1.start_time < s2.end_time
    and s1.end_time > s2.start_time;


-- 16. Unregistered Active Users 
-- Find users who created an account in the last 30 days but haven’t registered for any events. 

select u.user_id,u.full_name,u.registration_date
from Users as u
left join Registrations as r on u.user_id=r.user_id 
where u.registration_date >= CURDATE() - INTERVAL 30 DAY
and r.user_id is null;

-- 17. Multi-Session Speakers 
-- Identify speakers who are handling more than one session across all events.

select speaker_name,count(*) as session_count
from Sessions
group by speaker_name
having count(*)>1;

-- 18. Resource Availability Check 
-- List all events that do not have any resources uploaded. 

select e.event_id,e.title
from Events e
left join Resources r on e.event_id=r.event_id
where r.resource_id is null;

-- 19. Completed Events with Feedback Summary 
-- For completed events, show total registrations and average feedback rating. 

select e.event_id,e.title,e.status,count(distinct r.registration_id) as total_reg,avg(f.rating)
from Events e
left join Feedback f on e.event_id=f.event_id
left join Registrations r on e.event_id=r.event_id
where e.status='completed'
group by e.event_id,e.title,e.status;

-- 20. User Engagement Index 
-- For each user, calculate how many events they attended and how many feedbacks they 
-- submitted. 

select u.user_id,u.full_name,count ( distinct r.registration_id) as total_reg,count(distinct f.feedback_id) as total_feed
from Users u
left join Registrations r on u.user_id=r.user_id
left join Feedback f on u.user_id=f.user_id
group by u.user_id,u.full_name;

-- 21. Top Feedback Providers 
-- List top 5 users who have submitted the most feedback entries. 

select u.user_id,u.full_name,count(*) as feedback_count
from Users u
join Feedback f on u.user_id=f.user_id
group by u.user_id,u.full_name
order by feedback_count desc
limit 5;

-- 22. Duplicate Registrations Check 
-- Detect if a user has been registered more than once for the same event. 

select user_id,event_id,count(*) as reg_count
from Registrations
group by user_id,event_id
having count(*)>1;

-- 24. Average Session Duration per Event 
-- Compute the average duration (in minutes) of sessions in each event.

select event_id,
    avg(TIMESTAMPDIFF(MINUTE,start_time,end_time)) as avg_minute_count
from Sessions
group by event_id;

-- 25. Events Without Sessions 
-- List all events that currently have no sessions scheduled under them. 

select e.event_id,e.title
from Events e
left join Sessions s on e.event_id=s.event_id
where s.session_id is null;