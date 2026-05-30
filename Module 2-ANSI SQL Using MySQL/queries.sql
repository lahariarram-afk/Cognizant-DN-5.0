---1
select * 
from Users 
inner join Registrations on Registrations.user_id=Users.user_id
inner join Events on Events.event_id=Registrations.event_id
where Events.status='upcoming' and Events.city=Users.city
order by Events.start_date asc;