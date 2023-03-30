package com.careerit.psa.dao;

public class ProductQueries {

    public static final String ADD_PRODUCT= "insert into product(name,description,price,discount) values(?,?,?,?)";
    public static final String UPDATE_PRODUCT="update product set name=?,description=?,price=?,discount=? where id=?";
    public static final String GET_PRODUCT = "select id,name,description,price,discount from product where pid=? and deleted=false";
    public static final String GET_PRODUCTS = "select id,name,description,price,discount from product where deleted=false";
    public static final String DELETE_PRODUCT = "delet from product where id=?";
}
