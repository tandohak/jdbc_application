-- 존재시 삭제
drop database if exists coffee_Project; 
-- db 생성
create database coffee_Project;
-- db use
use coffee_project;

-- 제품코드 테이블
create table if not exists coffee_project.productCode(
	producCode char(10) primary key,
	producName char(10)
);

-- 제품테이블
create table if not exists coffee_project.product(
	proCode char(10) not null unique,
	price int(10),
	sale int(10),
	margin int(10),
	foreign key (proCode) references productCode(producCode) 
	on delete cascade
	on update cascade
);


-- 판매 실적 현황 리포트 테이블
create table if not exists coffee_project.coffeeReport(
	proCode char(10) not null unique,
	priceSum int(10),
	surtax int(10),
	supply int(10),
	marginPrice int(10),
	foreign key (proCode) references product(proCode)
	on delete cascade
	on update cascade
);

-- insert trigger 생성
drop trigger if exists coffee_project.tri_product_after_insert_coffeeReport;
delimiter $$
create trigger coffee_project.tri_product_after_insert_coffeeReport
after insert
on coffee_project.product
for each row
begin
	insert into coffee_project.coffeeReport
	values(
		new.proCode,		
		new.price*new.sale, 
		ceiling(new.price/11), 
		new.price-ceiling(new.price/11),		
		round(new.margin*(new.price-(new.price/11)))
		);	
end $$
delimiter ;

-- update trigger 생성
drop trigger if exists coffee_project.tri_product_after_update_cofeeReport;
delimiter $$
create trigger coffee_project.tri_product_after_update_cofeeReport
after update
on coffee_project.product
for each row
begin
	
	update coffee_project.coffeeReport 
	set priceSum = new.price*new.sale,
		surtax = ceiling(new.price/11),
		supply = new.price-ceiling(new.price/11),
		marginPrice = round(new.margin*(new.price-(new.price/11)))
	where proCode = new.proCode;
	
end $$
delimiter ;


-- 판매금액순 뷰테이블 생성
create view coffee_project.coffeeReport_ranked_priceSum as
select (select count(*)+1 from coffee_project.coffeereport where priceSum > c.priceSum) as rank,
p.proCode, price, sale, priceSum, surtax, supply, marginPrice 
from coffee_project.product p  join coffee_project.coffeereport c join coffee_project.productCode pc
where p.proCode = c.proCode 
group by proCode
order by priceSum desc;

-- 마진액 순위 뷰테이블 생성
create view coffee_project.coffeeReport_ranked_marginPrice as
select (select count(*)+1 from coffee_project.coffeereport where marginPrice > c.marginPrice) as rank,
p.proCode, pc.producName, price, sale, priceSum, surtax, supply, marginPrice 
from coffee_project.product p  join coffee_project.coffeereport c join coffee_project.productCode pc
where p.proCode = c.proCode
group by proCode
order by marginPrice desc ;

