# Write your MySQL query statement below


#select name as Customers from customers where id not in (select customerId from orders)


# Write your MySQL query statement below
select cu.name as Customers from Customers as cu 
left join Orders as o on cu.id = o.customerId 
where o.customerId is null;