package com.harman.Product_Management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Product_Management {

    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int option;

        while(true) {
            System.out.println("1. Add the PRODUCTS ");
            System.out.println("2. View All products ");
            System.out.println("3. Search a product using product code ");
            System.out.println("4. Update product details using product Code");
            System.out.println("5. Delete a product  using product Code ");
            System.out.println("6. Display all the details of products  whose price  is greater than 50000");
            System.out.println("7. Display the count of total number of products  in the company");
            System.out.println("8. Display all the product details in alphabetical order");
            System.out.println("9. EXIT");
            System.out.println("Enter Your choice from the above menu : ");
            option=in.nextInt();

            switch(option) {
                case 1:
                    try {
                        Connection c= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompany?autoReconnect=true&useSSL=false","root","");
                        Scanner s=new Scanner(System.in);
                        String productcode,productname,brand,price,model,manufacturingyear,expirydate;
                        System.out.println("Product Code :");
                        productcode=s.nextLine();
                        System.out.println("Product Name :");
                        productname=s.nextLine();
                        System.out.println("Brand :");
                        brand=s.nextLine();
                        System.out.println("Price :");
                        price=s.nextLine();
                        System.out.println("Model :");
                        model=s.nextLine();
                        System.out.println("Year of Manufacturing :");
                        manufacturingyear=s.nextLine();
                        System.out.println("Exipry Date :");
                        expirydate=s.nextLine();

                        Statement stmt=c.createStatement();
                        stmt.executeUpdate("INSERT INTO `products`( `product_code`, `product_name`, `brand`, `price`, `model`, `manufacturing_year`, `expiry_date`) VALUES("+productcode+",'"+productname+"','"+brand+"',"+price+",'"+model+"',"+manufacturingyear+",'"+expirydate+"') ");
                        System.out.println("Product Details Inserted Successfully");

                    }
                    catch(Exception e) {
                        System.out.println(e);
                    }
                    break;

                case 2:
                    try {
                        Connection c= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompany?autoReconnect=true&useSSL=false","root","");
                        Statement stmt=c.createStatement();
                        ResultSet rs=stmt.executeQuery("select * from products");
                        while(rs.next()) {
                            System.out.println("ID :"+rs.getInt("ID"));
                            System.out.println("Product Code :"+rs.getBigDecimal("product_code"));
                            System.out.println("Product Name :"+rs.getString("product_name"));
                            System.out.println("Brand :"+rs.getString("brand"));
                            System.out.println("Price :"+rs.getInt("price"));
                            System.out.println("Model :"+rs.getString("model"));
                            System.out.println("Manufacturing Year :"+rs.getString("manufacturing_year"));
                            System.out.println("Expiry Date :"+rs.getString("expiry_date"));
                        }
                    }
                    catch(Exception e) {
                        System.out.println(e);
                    }
                    break;

                case 3:
                    try {
                        Connection c= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompany?autoReconnect=true&useSSL=false","root","");

                        Scanner s=new Scanner(System.in);
                        System.out.println("Enter the Product code :");
                        String productcode=s.nextLine();
                        java.sql.Statement stmt=c.createStatement();
                        ResultSet rs=stmt.executeQuery("select * from products where product_code="+productcode);
                        while(rs.next()) {
                            System.out.println("ID :"+rs.getInt("ID"));
                            System.out.println("Product Code :"+rs.getBigDecimal("product_code"));
                            System.out.println("Product Name :"+rs.getString("product_name"));
                            System.out.println("Brand :"+rs.getString("brand"));
                            System.out.println("Price :"+rs.getInt("price"));
                            System.out.println("Model :"+rs.getString("model"));
                            System.out.println("Manufacturing Year :"+rs.getString("manufacturing_year"));
                            System.out.println("Expiry Date :"+rs.getString("expiry_date"));
                        }
                    }
                    catch(Exception e) {
                        System.out.println(e);
                    }
                    break;

                case 4:
                    try {
                        Connection c= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompany?autoReconnect=true&useSSL=false","root","");

                        Scanner s=new Scanner(System.in);
                        String productcode,productname,brand,price,model,manufacturingyear,expirydate;
                        System.out.println("Enter the Product code to get Update :");
                        productcode=s.nextLine();

                        System.out.println("Product Name :");
                        productname=s.nextLine();
                        System.out.println("Brand :");
                        brand=s.nextLine();
                        System.out.println("Price :");
                        price=s.nextLine();
                        System.out.println("Model :");
                        model=s.nextLine();
                        System.out.println("Year of Manufacturing :");
                        manufacturingyear=s.nextLine();
                        System.out.println("Exipry Date :");
                        expirydate=s.nextLine();

                        Statement stmt=c.createStatement();
                        stmt.executeUpdate("update products set product_name='"+productname+"',brand='"+brand+"',price="+price+",model='"+model+"',manufacturing_year="+manufacturingyear+",expiry_date='"+expirydate+"' WHERE product_code="+productcode+"");
                        System.out.println("Updated Successfully");


                    }
                    catch(Exception e) {
                        System.out.println(e);
                    }
                    break;

                case 5:
                    try {
                        Connection c= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompany?autoReconnect=true&useSSL=false","root","");

                        Scanner s=new Scanner(System.in);
                        String productcode;
                        System.out.println("Delete Product data using Product code :");
                        productcode=s.nextLine();
                        Statement stmt=c.createStatement();
                        stmt.executeUpdate("delete from products where product_code="+productcode+"");

                        System.out.println("Product data Deleted Successfully");

                    }
                    catch(Exception e) {
                        System.out.println(e);
                    }
                    break;

                case 6:
                    try {
                        Connection c= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompany?autoReconnect=true&useSSL=false","root","");

                        Statement stmt=c.createStatement();
                        ResultSet rs=stmt.executeQuery("select * from products where price > 50000");
                        while(rs.next()) {
                            System.out.println("ID :"+rs.getInt("ID"));
                            System.out.println("Product Code :"+rs.getBigDecimal("product_code"));
                            System.out.println("Product Name :"+rs.getString("product_name"));
                            System.out.println("Brand :"+rs.getString("brand"));
                            System.out.println("Price :"+rs.getInt("price"));
                            System.out.println("Model :"+rs.getString("model"));
                            System.out.println("Manufacturing Year :"+rs.getString("manufacturing_year"));
                            System.out.println("Expiry Date :"+rs.getString("expiry_date"));
                        }
                    }
                    catch(Exception e) {
                        System.out.println(e);
                    }
                    break;

                case 7:
                    try {
                        Connection c= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompany?autoReconnect=true&useSSL=false","root","");
                        int count=0;
                        Statement stmt=c.createStatement();
                        ResultSet rs=stmt.executeQuery("select product_name from products");
                        while(rs.next()) {
                            count++;
                        }
                        System.out.println("Total Products : "+count);
                    }
                    catch(Exception e) {
                        System.out.println(e);
                    }
                    break;

                case 8:
                    try {
                        Connection c= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompany?autoReconnect=true&useSSL=false","root","");

                        Statement stmt=c.createStatement();
                        ResultSet rs=stmt.executeQuery("select * from products order by product_name");
                        while(rs.next()) {
                            System.out.println("ID :"+rs.getInt("ID"));
                            System.out.println("Product Code :"+rs.getBigDecimal("product_code"));
                            System.out.println("Product Name :"+rs.getString("product_name"));
                            System.out.println("Brand :"+rs.getString("brand"));
                            System.out.println("Price :"+rs.getInt("price"));
                            System.out.println("Model :"+rs.getString("model"));
                            System.out.println("Manufacturing Year :"+rs.getString("manufacturing_year"));
                            System.out.println("Expiry Date :"+rs.getString("expiry_date"));
                        }
                    }
                    catch(Exception e) {
                        System.out.println(e);
                    }
                    break;

                case 9:
                    System.exit(0);

                default:
                    System.out.println("You have choosed INVALID option.....try again by choosing valid option from the below menu!");
            }
        }

    }
}