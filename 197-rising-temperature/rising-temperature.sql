select w1.id
from Weather as w1
join Weather as w2
on Datediff(w1.recordDate,w2.recordDate)=1
and w1.temperature>w2.temperature;