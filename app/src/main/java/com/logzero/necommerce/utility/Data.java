package com.logzero.necommerce.utility;

import android.util.Log;

import com.logzero.necommerce.R;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Data {

    public static final String BASE_SITE = "development-review.net/ecommerce";
    public static final  String COSTUMER_KEY="ck_48a6faf3ff255051a18ee235da4bddbaf31231f1";
    public static final String COSTUMER_SECRET ="cs_16eb8c1619ac5bf07bc365e02c990abbb95bbec8";
    public static final  String METHORD="GET";//change API method eg POST,PUT, DELETE etc (ONLY FOR THIS EXAMPLE FOR LIB LIKE RETROFIT,OKHTTP, The Are Dynamic Way)
    //Product list
    public static final  String BASE_URL = "http://"+BASE_SITE+"/wp-json/wc/v3/products";
    public static final  String MEN_URL = "http://"+BASE_SITE+"/wp-json/wc/v3/men";

    public static String encodeUrl(String url) {
        String encodedurl = "";
        try {

            encodedurl = URLEncoder.encode(url, "UTF-8");
            Log.d("Encodeurl", encodedurl);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return encodedurl;
    }

    public static final int boots_image[] = {
            R.drawable.wtshirt1,
            R.drawable.fwtshirt2,
            R.drawable.fwtshirt3,
            R.drawable.fwtshirt4,
            R.drawable.fwtshirt5,
    };

    public static final String boot_name[] = {
            "Lacoste",
            "GAP",
            "Levi's",
            "Adidas",
            "Lee"
    };

    public static final String boot_subtitle[] = {
            "Crocodile Women's Polo Shirt",
            "GAP Women's Short Sleeve Lurex T-Shirt",
            "Denim Blouses, Tank Tops & T-Shirts",
            "adidas Women's Badge Of Sport Classic Graphic Tee",
            "Floral Graphic Tee |  Bright White  "
    };

    public static final String boot_price[] = {
            "$47.00",
            "$47.00",
            "$47.00",
            "$47.00",
            "$47.00"
    };


    public static final int sunglass_image[] = {
            R.drawable.wfdress1,
            R.drawable.wdress2,
            R.drawable.wdress3,
            R.drawable.wdress4,
            R.drawable.wdress5,
    };

    public static final String sunglass_name[] = {
            "Libas",
            "AKS",
            "Nayo",
            "Johaena",
            "Vishudh"
    };

    public static final String sunglass_subtitle[] = {
            "Women Black & Golden Block Print Maxi Dress",
            "Women Navy Blue & Green Layered Maxi Dress",
            "Women Pink & White Printed Maxi Dress",
            "Women Black Solid A-Line Dress",
            "Women Grey & Gold-Toned Printed Maxi Dress"
    };

    public static final String sunglass_price[] = {
            "$107.00",
            "$227.00",
            "$507.00",
            "$203.00",
            "$302.00"
    };

    public static final int tos_image[] = {
            R.drawable.ftunics1,
            R.drawable.tos2,
            R.drawable.tos3,
            R.drawable.tos4,
            R.drawable.tos5,
    };

    public static final String tos_name[] = {
            "Serein",
            "GSA MALL",
            "Kvsfab",
            "Patiala House",
            "Snehal Creation"
    };

    public static final String tos_subtitle[] = {
            "Solid Women Tunic",
            "Checkered Women Tunic",
            "Embroidered Women Tunic",
            "Embroidered Women Tunic",
            "Printed Women Tunic"
    };

    public static final String tos_price[] = {
            "$247.00",
            "$357.00",
            "$247.00",
            "$147.00",
            "$347.00"
    };


    public static final int purse_image[] = {
            R.drawable.purse1,
            R.drawable.purse2,
            R.drawable.purse3,
            R.drawable.purse4,
            R.drawable.purse5,
    };

    public static final String purse_name[] = {
            "Craft Trade",
            "SAHAL",
            "Diana Korr",
            "Element Cart",
            "FANEX"
    };

    public static final String purse_subtitle[] = {
            "Hand-held Bag",
            "Hand-held Bag",
            "Hand-held Bag",
            "Hand-held Bag",
            "Hand-held Bag"
    };

    public static final String purse_price[] = {
            "$247.00",
            "$357.00",
            "$247.00",
            "$147.00",
            "$347.00"
    };

    public static final int wallet_image[] = {
            R.drawable.fmenwallet1,
            R.drawable.wallet2,
            R.drawable.wallet3,
            R.drawable.wallet4,
            R.drawable.wallet1,
    };

    public static final String wallet_name[] = {
            "Craft Trade",
            "SAHAL",
            "Diana Korr",
            "Element Cart",
            "FANEX"
    };

    public static final String wallet_subtitle[] = {
            "Genuine Leather Wallet ",
            "Genuine Leather Wallet ",
            "Genuine Leather Wallet ",
            "Genuine Leather Wallet ",
            "Genuine Leather Wallet "
    };

    public static final String wallet_price[] = {
            "$247.00",
            "$357.00",
            "$247.00",
            "$147.00",
            "$347.00"
    };

    public static final int shirt_image[] = {
            R.drawable.fmtshirt1,
            R.drawable.shirt2,
            R.drawable.shirt3,
            R.drawable.shirt4,
            R.drawable.shirt5,
    };

    public static final String shirt_name[] = {
            "ARROW BLUE JEANS",
            "Arrow Sport",
            "WEAR ME",
            "ME&YOU",
            "Envy Me"
    };

    public static final String shirt_subtitle[] = {
            "Casual Shirt",
            "Men Printed Casual Shirt",
            "Men Printed Casual Shirt",
            "Men Printed T-Shirt",
            "Men Printed Casual Shirt"
    };

    public static final String shirt_price[] = {
            "$247.00",
            "$357.00",
            "$247.00",
            "$147.00",
            "$347.00"
    };

    public static final int jeans_image[] = {
            R.drawable.fmenjeans1,
            R.drawable.menjeans2,
            R.drawable.menjeans3,
            R.drawable.menjeans4,
            R.drawable.menjeans5,
    };

    public static final String jeans_name[] = {
            "ARROW BLUE JEANS",
            "Arrow Sport",
            "WEAR ME",
            "ME&YOU",
            "Newport"
    };

    public static final String jeans_subtitle[] = {
            "Men Dark Blue Jeans",
            "Men Dark Jeans",
            "Men Dark Jeans",
            "Men Dark Jeans",
            "Men Dark Jeans"
    };

    public static final String jeans_price[] = {
            "$247.00",
            "$357.00",
            "$247.00",
            "$147.00",
            "$347.00"
    };

    public static final int addtocart_image[] = {
            R.drawable.shirt1,
            R.drawable.shirt2,

    };

    public static final String addtocart_name[] = {
            "ARROW BLUE JEANS",
            "Arrow Sport",

    };

    public static final String addtocart_subtitle[] = {
            "Men Dark Blue Jeans",
            "Men Dark Jeans",

    };

    public static final String addtocart_price[] = {
            "$247.00",
            "$357.00",
    };

    public static final int notification_image[] = {
            R.drawable.shirt1,
            R.drawable.shirt2,

    };

    public static final String notification_name[] = {
            "ARROW BLUE JEANS",
            "Arrow Sport",

    };

    public static final String notification_subtitle[] = {
            "Men Dark Blue Jeans",
            "Men Dark Jeans",

    };

    public static final String notification_price[] = {
            "$247.00",
            "$357.00",
    };

    public static final int watch_image[] = {
            R.drawable.fmenwatch1,
            R.drawable.menwatch2,
            R.drawable.menwatch3,
            R.drawable.menwatch4,
            R.drawable.menwatch5,
    };

    public static final String watch_name[] = {
            "Espoir ",
            "Fastrack",
            "Casio",
            "Fossil",
            "Sonata"
    };

    public static final String watch_subtitle[] = {
            "CheckBlueRay0507 DAY AND DATE FUNCTIONING Analog Watch",
            "38034SP01J Analog-Digital Watch - For Men",
            "472 Day & Date Series Stylish Black Leather Belt Watch For Men & Hybrid Smartwatch Watch - For Boys",
            "A1177 Enticer Men's Smart Analog Watch - For Men",
            "Original Black Dial Working Day & Date Display Gold Plated Water Resistant Metal Bracelet"
    };

    public static final String watch_price[] = {
            "$247.00",
            "$357.00",
            "$247.00",
            "$147.00",
            "$347.00"
    };

    public static final int palazzo_image[] = {
            R.drawable.fpalazzo1,
            R.drawable.wplazo1,
            R.drawable.wplazo2,
            R.drawable.wplazo3,
            R.drawable.wplazo4,
    };

    public static final String palazzo_name[] = {
            "SHEIN ",
            "Brand Factory",
            "Catalog Fashion",
            "Brand Factory",
            "SHEIN"
    };

    public static final String palazzo_subtitle[] = {
            "Ruffle Trim Button Front Belted Palazzo Jumpsuit",
            "Guipure Lace Yoke Cold Shoulder Palazzo Jumpsuit",
            "Frill Waist Belted Palazzo Pants",
            "High Waist Tribal Print Super Palazzo Pants",
            "Girls Ruffle Trim One Shoulder Crop Top & Palazzo Pants Set"
    };

    public static final String palazzo_price[] = {
            "$247.00",
            "$357.00",
            "$247.00",
            "$147.00",
            "$347.00"
    };


    public static final int checkout_image[] = {
            R.drawable.wtshirt1,
            R.drawable.fpalazzo1,
            R.drawable.fmenwatch1,
    };

    public static final String checkout_name[] = {
            "Lacoste",
            "SHEIN ",
            "Espoir",
    };

    public static final String checkout_subtitle[] = {
            "Crocodile Women's Polo Shirt",
            "Ruffle Trim Button Front Belted Palazzo Jumpsuit",
            "CheckBlueRay0507 DAY AND DATE FUNCTIONING Analog Watch",
    };

    public static final String checkout_price[] = {
            "$247.00",
            "$357.00",
            "$247.00",

    };


    public static final int kidtshirt_image[] = {
            R.drawable.fkidtshirt1,
            R.drawable.kidtshirt1,
            R.drawable.kidtshirt2,
            R.drawable.kidtshirt3,
            R.drawable.fkidtshirt4,
    };

    public static final String kidtshirt_name[] = {
            "Gini and Jony ",
            "Palm Tree",
            "Monte Carlo",
            "Puma",
            "Pepe Jeans"
    };

    public static final String kidtshirt_subtitle[] = {
            "Unisex Pack of 5 Printed T-shirts",
            "Unisex Printed Round Neck T-shirt",
            "Unisex Printed Round Neck T-shirt",
            "Unisex Printed Round Neck T-shirt",
            "Unisex Printed Round Neck T-shirt"
    };

    public static final String kidtshirt_price[] = {
            "$247.00",
            "$357.00",
            "$247.00",
            "$147.00",
            "$347.00"
    };
    public static final int kidtjeans_image[] = {
            R.drawable.fkidjeans1,
            R.drawable.kidjeans1,
            R.drawable.kidjeans2,
            R.drawable.kidjeans3,
            R.drawable.kidjeans4,
    };

    public static final String kidtjeans_name[] = {
            "GAP",
            "H & M",
            "Mini Club",
            "Puma",
            "Tommy Hilfiger"
    };

    public static final String kidtjeans_subtitle[] = {
            "Boys' Cord Lined Pull-On Jeans",
            "Unisex Lined Pull-On Jeans",
            "Unisex Lined Pull-On Jeans",
            "Unisex Lined Pull-On Jeans",
            "Unisex Lined Pull-On Jeans"
    };

    public static final String kidtjeans_price[] = {
            "$247.00",
            "$357.00",
            "$247.00",
            "$147.00",
            "$347.00"
    };

    public static final int kidtcloth_image[] = {
            R.drawable.fkidcloth1,
            R.drawable.kidcloth1,
            R.drawable.kidcloth2,
            R.drawable.kidcloth3,
            R.drawable.kidcloth4,
    };

    public static final String kidtcloth_name[] = {
            "GAP",
            "H & M",
            "Mini Club",
            "Puma",
            "Tommy Hilfiger"
    };

    public static final String kidtcloth_subtitle[] = {
            "Boys' Cord Lined Pull-On Jeans",
            "Unisex Lined Pull-On Clothes",
            "Unisex Lined Pull-On Clothes",
            "Unisex Lined Pull-On Clothes",
            "Unisex Lined Pull-On Clothes"
    };

    public static final String kidtcloth_price[] = {
            "$247.00",
            "$357.00",
            "$247.00",
            "$147.00",
            "$347.00"
    };

    public static final int kidtshort_image[] = {
            R.drawable.fkidskirt1,
            R.drawable.kidskirt1,
            R.drawable.kidskirt2,
            R.drawable.kidskirt3,
            R.drawable.kidskirt4,
    };

    public static final String kidtshort_name[] = {
            "GAP",
            "H & M",
            "Mini Club",
            "Puma",
            "Tommy Hilfiger"
    };

    public static final String kidtshort_subtitle[] = {
            "Girl' Cord Lined Pull-On Skirt",
            "Unisex Lined Pull-On Skirt",
            "Unisex Lined Pull-On Short",
            "Unisex Lined Pull-On Short",
            "Unisex Lined Pull-On Skirt"
    };

    public static final String kidtshort_price[] = {
            "$247.00",
            "$357.00",
            "$247.00",
            "$147.00",
            "$347.00"
    };
}
