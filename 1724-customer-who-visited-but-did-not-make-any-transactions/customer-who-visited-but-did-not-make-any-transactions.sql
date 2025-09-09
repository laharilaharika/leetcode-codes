-- select v.customer_id,
-- from Visits as v
-- join Transactions as t 
-- on v.visit_id=t.visit_id
-- group by v.customer_id;
select customer_id,count(*) as count_no_trans
from Visits where visit_id not in(select visit_id from Transactions) 
group by customer_id;