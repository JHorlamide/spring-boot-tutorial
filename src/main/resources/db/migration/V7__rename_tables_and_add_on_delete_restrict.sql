alter table category rename to categories;
alter table product rename to products;

alter table products drop foreign key product_category_category_id_fk;

alter table products
add constraint products_category_id_fk
foreign key (category_id)
references categories (id)
on delete restrict ;