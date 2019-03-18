package uuu.vgb.test;

import uuu.gtt.entity.Product;
import uuu.gtt.entity.VGBException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




/**
 *
 * @author Administrator
 */
public class TestProduct {
    public static void main(String[] args) throws VGBException {
        int i = 100;
        int j = i;
        i=i+1;
        System.out.println("i = " + i); //101
        System.out.println("j = " + j); //100
        
        Product p = new Product(1, 
                "絕美.花之繪：色鉛筆的優雅描畫×花卉彩繪技法 暢銷珍藏版", 450, 20);        
//        p.setId(1);
//        p.setName("絕美.花之繪：色鉛筆的優雅描畫×花卉彩繪技法 暢銷珍藏版");
//        p.setUnitPrice(450);

            p.setPrice(450);
            p.setDiscount(20);
        p.setPhotoUrl("http://im1.book.com.tw/image/getImage?i=http://www.books.com.tw/img/001/074/40/0010744083.jpg&w=85&h=120&v=58be602e");
        p.setDescription("用色鉛筆畫出謐靜自如的花姿態...。收錄生活中常見的各式美麗花卉，"
                + "運用柔和細膩的色鉛筆，將它們優美的姿態描繪出來，"
                + "並且介紹每種花的科屬分類和主要的形態特徵。本書既可作為識別花卉的小圖鑑，"
                + "更可作為色鉛筆的繪畫技法書。");
        
        System.out.println("p.getId() = " + p.getId());
        System.out.println("p.getName() = " + p.getName());
        
        
        System.out.println("p.getPrice()售價 = " + p.getPrice());
                System.out.println("折扣"+p.getDiscount());
                System.out.println("定價"+p.getUnitPrice());
        
        System.out.println("p.getStock() = " + p.getStock());
        System.out.println("p.getDescription() = " + p.getDescription());
        System.out.println("p.getPhotoUrl() = " + p.getPhotoUrl());
        
        Product p2 = p;

//        Product p2 = new Product();
//        p2.setId(p.getId());
//        p2.setName(p.getName());
//        p2.setUnitPrice(p.getUnitPrice());
//        p2.setStock(p.getStock());
//        p2.setDescription(p.getDescription());
//        p2.setPhotoUrl(p.getPhotoUrl());
        
        p2.setUnitPrice(p.getUnitPrice()+100);
        System.out.println("p = " + p.getUnitPrice()); //?
        System.out.println("p2 = " + p2.getUnitPrice());//550    
    }
}
