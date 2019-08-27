package com.logzero.necommerce.allproductmodel;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class AllProduct implements Parcelable {

    private int id;
    private String name;
    private String slug;
    private String permalink;
    private String date_created;
    private String date_created_gmt;
    private String date_modified;
    private String date_modified_gmt;
    private String type;
    private String status;
    private boolean featured;
    private String catalog_visibility;
    private String description;
    private String short_description;
    private String sku;
    private String price;
    private String regular_price;
    private String sale_price;
    private String date_on_sale_from;
    private String date_on_sale_from_gmt;
    private String date_on_sale_to;
    private String date_on_sale_to_gmt;
    private String price_html;
    private boolean on_sale;
    private boolean purchasable;
    private int total_sales;
    private boolean virtual;
    private boolean downloadable;
    private ArrayList downloads;
    private int download_limit;
    private int download_expiry;
    private String external_url;
    private String button_text;
    private String tax_status;
    private String tax_class;
    private boolean manage_stock;
    private String stock_quantity;
    private String stock_status;
    private String backorders;
    private boolean backorders_allowed;
    private boolean backordered;
    private boolean sold_individually;
    private String weight;
    private DiamentionModel dimensions;
    private boolean shipping_required;
    private boolean shipping_taxable;
    private String shipping_class;
    private int shipping_class_id;
    private boolean reviews_allowed;
    private String average_rating;
    private int rating_count;
   // private ArrayList<RelatedIdModel> related_ids;
    private ArrayList upsell_ids;
    private ArrayList cross_sell_ids;
    private int parent_id;
    private String purchase_note;
    private ArrayList<CategoryModel> categories;
    private ArrayList<TagsModel> tags;
    private ArrayList<ImagesModel> images;
    private ArrayList attributes;
    private ArrayList default_attributes;
    private ArrayList variations;
    private ArrayList grouped_products;
    private int menu_order;

    public AllProduct(int id, String name, String slug, String permalink,
                      String date_created, String date_created_gmt,
                      String date_modified, String date_modified_gmt,
                      String type, String status, boolean featured,
                      String catalog_visibility, String description,
                      String short_description, String sku, String price,
                      String regular_price, String sale_price,
                      String date_on_sale_from, String date_on_sale_from_gmt,
                      String date_on_sale_to, String date_on_sale_to_gmt,
                      String price_html, boolean on_sale, boolean purchasable,
                      int total_sales, boolean virtual, boolean downloadable,
                      ArrayList downloads, int download_limit, int download_expiry,
                      String external_url, String button_text, String tax_status,
                      String tax_class, boolean manage_stock,
                      String stock_quantity, String stock_status,
                      String backorders, boolean backorders_allowed,
                      boolean backordered, boolean sold_individually,
                      String weight, DiamentionModel dimensions,
                      boolean shipping_required, boolean shipping_taxable,
                      String shipping_class, int shipping_class_id,
                      boolean reviews_allowed, String average_rating,
                      int rating_count, ArrayList<RelatedIdModel> related_ids,
                      ArrayList upsell_ids, ArrayList cross_sell_ids,
                      int parent_id, String purchase_note,
                      ArrayList<CategoryModel> categories,
                      ArrayList<TagsModel> tags, ArrayList<ImagesModel> images,
                      ArrayList attributes, ArrayList default_attributes,
                      ArrayList variations, ArrayList grouped_products,
                      int menu_order, ArrayList<MetaDataModel> meta_data,
                      LinkModel _links) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.permalink = permalink;
        this.date_created = date_created;
        this.date_created_gmt = date_created_gmt;
        this.date_modified = date_modified;
        this.date_modified_gmt = date_modified_gmt;
        this.type = type;
        this.status = status;
        this.featured = featured;
        this.catalog_visibility = catalog_visibility;
        this.description = description;
        this.short_description = short_description;
        this.sku = sku;
        this.price = price;
        this.regular_price = regular_price;
        this.sale_price = sale_price;
        this.date_on_sale_from = date_on_sale_from;
        this.date_on_sale_from_gmt = date_on_sale_from_gmt;
        this.date_on_sale_to = date_on_sale_to;
        this.date_on_sale_to_gmt = date_on_sale_to_gmt;
        this.price_html = price_html;
        this.on_sale = on_sale;
        this.purchasable = purchasable;
        this.total_sales = total_sales;
        this.virtual = virtual;
        this.downloadable = downloadable;
        this.downloads = downloads;
        this.download_limit = download_limit;
        this.download_expiry = download_expiry;
        this.external_url = external_url;
        this.button_text = button_text;
        this.tax_status = tax_status;
        this.tax_class = tax_class;
        this.manage_stock = manage_stock;
        this.stock_quantity = stock_quantity;
        this.stock_status = stock_status;
        this.backorders = backorders;
        this.backorders_allowed = backorders_allowed;
        this.backordered = backordered;
        this.sold_individually = sold_individually;
        this.weight = weight;
        this.dimensions = dimensions;
        this.shipping_required = shipping_required;
        this.shipping_taxable = shipping_taxable;
        this.shipping_class = shipping_class;
        this.shipping_class_id = shipping_class_id;
        this.reviews_allowed = reviews_allowed;
        this.average_rating = average_rating;
        this.rating_count = rating_count;
      //  this.related_ids = related_ids;
        this.upsell_ids = upsell_ids;
        this.cross_sell_ids = cross_sell_ids;
        this.parent_id = parent_id;
        this.purchase_note = purchase_note;
        this.categories = categories;
        this.tags = tags;
        this.images = images;
        this.attributes = attributes;
        this.default_attributes = default_attributes;
        this.variations = variations;
        this.grouped_products = grouped_products;
        this.menu_order = menu_order;
      //  this.meta_data = meta_data;
        this._links = _links;
    }

   // private ArrayList<MetaDataModel> meta_data;

    protected AllProduct(Parcel in) {
        id = in.readInt();
        name = in.readString();
        slug = in.readString();
        permalink = in.readString();
        date_created = in.readString();
        date_created_gmt = in.readString();
        date_modified = in.readString();
        date_modified_gmt = in.readString();
        type = in.readString();
        status = in.readString();
        featured = in.readByte() != 0;
        catalog_visibility = in.readString();
        description = in.readString();
        short_description = in.readString();
        sku = in.readString();
        price = in.readString();
        regular_price = in.readString();
        sale_price = in.readString();
        date_on_sale_from = in.readString();
        date_on_sale_from_gmt = in.readString();
        date_on_sale_to = in.readString();
        date_on_sale_to_gmt = in.readString();
        price_html = in.readString();
        on_sale = in.readByte() != 0;
        purchasable = in.readByte() != 0;
        total_sales = in.readInt();
        virtual = in.readByte() != 0;
        downloadable = in.readByte() != 0;
        download_limit = in.readInt();
        download_expiry = in.readInt();
        external_url = in.readString();
        button_text = in.readString();
        tax_status = in.readString();
        tax_class = in.readString();
        manage_stock = in.readByte() != 0;
        stock_quantity = in.readString();
        stock_status = in.readString();
        backorders = in.readString();
        backorders_allowed = in.readByte() != 0;
        backordered = in.readByte() != 0;
        sold_individually = in.readByte() != 0;
        weight = in.readString();
        dimensions = in.readParcelable(DiamentionModel.class.getClassLoader());
        shipping_required = in.readByte() != 0;
        shipping_taxable = in.readByte() != 0;
        shipping_class = in.readString();
        shipping_class_id = in.readInt();
        reviews_allowed = in.readByte() != 0;
        average_rating = in.readString();
        rating_count = in.readInt();
        parent_id = in.readInt();
        purchase_note = in.readString();
        categories = in.createTypedArrayList(CategoryModel.CREATOR);
        tags = in.createTypedArrayList(TagsModel.CREATOR);
        images = in.createTypedArrayList(ImagesModel.CREATOR);
        menu_order = in.readInt();
       // meta_data = in.createTypedArrayList(MetaDataModel.CREATOR);
        _links = in.readParcelable(LinkModel.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(slug);
        dest.writeString(permalink);
        dest.writeString(date_created);
        dest.writeString(date_created_gmt);
        dest.writeString(date_modified);
        dest.writeString(date_modified_gmt);
        dest.writeString(type);
        dest.writeString(status);
        dest.writeByte((byte) (featured ? 1 : 0));
        dest.writeString(catalog_visibility);
        dest.writeString(description);
        dest.writeString(short_description);
        dest.writeString(sku);
        dest.writeString(price);
        dest.writeString(regular_price);
        dest.writeString(sale_price);
        dest.writeString(date_on_sale_from);
        dest.writeString(date_on_sale_from_gmt);
        dest.writeString(date_on_sale_to);
        dest.writeString(date_on_sale_to_gmt);
        dest.writeString(price_html);
        dest.writeByte((byte) (on_sale ? 1 : 0));
        dest.writeByte((byte) (purchasable ? 1 : 0));
        dest.writeInt(total_sales);
        dest.writeByte((byte) (virtual ? 1 : 0));
        dest.writeByte((byte) (downloadable ? 1 : 0));
        dest.writeInt(download_limit);
        dest.writeInt(download_expiry);
        dest.writeString(external_url);
        dest.writeString(button_text);
        dest.writeString(tax_status);
        dest.writeString(tax_class);
        dest.writeByte((byte) (manage_stock ? 1 : 0));
        dest.writeString(stock_quantity);
        dest.writeString(stock_status);
        dest.writeString(backorders);
        dest.writeByte((byte) (backorders_allowed ? 1 : 0));
        dest.writeByte((byte) (backordered ? 1 : 0));
        dest.writeByte((byte) (sold_individually ? 1 : 0));
        dest.writeString(weight);
        dest.writeParcelable(dimensions, flags);
        dest.writeByte((byte) (shipping_required ? 1 : 0));
        dest.writeByte((byte) (shipping_taxable ? 1 : 0));
        dest.writeString(shipping_class);
        dest.writeInt(shipping_class_id);
        dest.writeByte((byte) (reviews_allowed ? 1 : 0));
        dest.writeString(average_rating);
        dest.writeInt(rating_count);
        dest.writeInt(parent_id);
        dest.writeString(purchase_note);
        dest.writeTypedList(categories);
        dest.writeTypedList(tags);
        dest.writeTypedList(images);
        dest.writeInt(menu_order);
        //dest.writeTypedList(meta_data);
        dest.writeParcelable(_links, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AllProduct> CREATOR = new Creator<AllProduct>() {
        @Override
        public AllProduct createFromParcel(Parcel in) {
            return new AllProduct(in);
        }

        @Override
        public AllProduct[] newArray(int size) {
            return new AllProduct[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public String getDate_created_gmt() {
        return date_created_gmt;
    }

    public void setDate_created_gmt(String date_created_gmt) {
        this.date_created_gmt = date_created_gmt;
    }

    public String getDate_modified() {
        return date_modified;
    }

    public void setDate_modified(String date_modified) {
        this.date_modified = date_modified;
    }

    public String getDate_modified_gmt() {
        return date_modified_gmt;
    }

    public void setDate_modified_gmt(String date_modified_gmt) {
        this.date_modified_gmt = date_modified_gmt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public String getCatalog_visibility() {
        return catalog_visibility;
    }

    public void setCatalog_visibility(String catalog_visibility) {
        this.catalog_visibility = catalog_visibility;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRegular_price() {
        return regular_price;
    }

    public void setRegular_price(String regular_price) {
        this.regular_price = regular_price;
    }

    public String getSale_price() {
        return sale_price;
    }

    public void setSale_price(String sale_price) {
        this.sale_price = sale_price;
    }

    public String getDate_on_sale_from() {
        return date_on_sale_from;
    }

    public void setDate_on_sale_from(String date_on_sale_from) {
        this.date_on_sale_from = date_on_sale_from;
    }

    public String getDate_on_sale_from_gmt() {
        return date_on_sale_from_gmt;
    }

    public void setDate_on_sale_from_gmt(String date_on_sale_from_gmt) {
        this.date_on_sale_from_gmt = date_on_sale_from_gmt;
    }

    public String getDate_on_sale_to() {
        return date_on_sale_to;
    }

    public void setDate_on_sale_to(String date_on_sale_to) {
        this.date_on_sale_to = date_on_sale_to;
    }

    public String getDate_on_sale_to_gmt() {
        return date_on_sale_to_gmt;
    }

    public void setDate_on_sale_to_gmt(String date_on_sale_to_gmt) {
        this.date_on_sale_to_gmt = date_on_sale_to_gmt;
    }

    public String getPrice_html() {
        return price_html;
    }

    public void setPrice_html(String price_html) {
        this.price_html = price_html;
    }

    public boolean isOn_sale() {
        return on_sale;
    }

    public void setOn_sale(boolean on_sale) {
        this.on_sale = on_sale;
    }

    public boolean isPurchasable() {
        return purchasable;
    }

    public void setPurchasable(boolean purchasable) {
        this.purchasable = purchasable;
    }

    public int getTotal_sales() {
        return total_sales;
    }

    public void setTotal_sales(int total_sales) {
        this.total_sales = total_sales;
    }

    public boolean isVirtual() {
        return virtual;
    }

    public void setVirtual(boolean virtual) {
        this.virtual = virtual;
    }

    public boolean isDownloadable() {
        return downloadable;
    }

    public void setDownloadable(boolean downloadable) {
        this.downloadable = downloadable;
    }

    public ArrayList getDownloads() {
        return downloads;
    }

    public void setDownloads(ArrayList downloads) {
        this.downloads = downloads;
    }

    public int getDownload_limit() {
        return download_limit;
    }

    public void setDownload_limit(int download_limit) {
        this.download_limit = download_limit;
    }

    public int getDownload_expiry() {
        return download_expiry;
    }

    public void setDownload_expiry(int download_expiry) {
        this.download_expiry = download_expiry;
    }

    public String getExternal_url() {
        return external_url;
    }

    public void setExternal_url(String external_url) {
        this.external_url = external_url;
    }

    public String getButton_text() {
        return button_text;
    }

    public void setButton_text(String button_text) {
        this.button_text = button_text;
    }

    public String getTax_status() {
        return tax_status;
    }

    public void setTax_status(String tax_status) {
        this.tax_status = tax_status;
    }

    public String getTax_class() {
        return tax_class;
    }

    public void setTax_class(String tax_class) {
        this.tax_class = tax_class;
    }

    public boolean isManage_stock() {
        return manage_stock;
    }

    public void setManage_stock(boolean manage_stock) {
        this.manage_stock = manage_stock;
    }

    public String getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(String stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public String getStock_status() {
        return stock_status;
    }

    public void setStock_status(String stock_status) {
        this.stock_status = stock_status;
    }

    public String getBackorders() {
        return backorders;
    }

    public void setBackorders(String backorders) {
        this.backorders = backorders;
    }

    public boolean isBackorders_allowed() {
        return backorders_allowed;
    }

    public void setBackorders_allowed(boolean backorders_allowed) {
        this.backorders_allowed = backorders_allowed;
    }

    public boolean isBackordered() {
        return backordered;
    }

    public void setBackordered(boolean backordered) {
        this.backordered = backordered;
    }

    public boolean isSold_individually() {
        return sold_individually;
    }

    public void setSold_individually(boolean sold_individually) {
        this.sold_individually = sold_individually;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public DiamentionModel getDimensions() {
        return dimensions;
    }

    public void setDimensions(DiamentionModel dimensions) {
        this.dimensions = dimensions;
    }

    public boolean isShipping_required() {
        return shipping_required;
    }

    public void setShipping_required(boolean shipping_required) {
        this.shipping_required = shipping_required;
    }

    public boolean isShipping_taxable() {
        return shipping_taxable;
    }

    public void setShipping_taxable(boolean shipping_taxable) {
        this.shipping_taxable = shipping_taxable;
    }

    public String getShipping_class() {
        return shipping_class;
    }

    public void setShipping_class(String shipping_class) {
        this.shipping_class = shipping_class;
    }

    public int getShipping_class_id() {
        return shipping_class_id;
    }

    public void setShipping_class_id(int shipping_class_id) {
        this.shipping_class_id = shipping_class_id;
    }

    public boolean isReviews_allowed() {
        return reviews_allowed;
    }

    public void setReviews_allowed(boolean reviews_allowed) {
        this.reviews_allowed = reviews_allowed;
    }

    public String getAverage_rating() {
        return average_rating;
    }

    public void setAverage_rating(String average_rating) {
        this.average_rating = average_rating;
    }

    public int getRating_count() {
        return rating_count;
    }

    public void setRating_count(int rating_count) {
        this.rating_count = rating_count;
    }

    /*public ArrayList<RelatedIdModel> getRelated_ids() {
        return related_ids;
    }

    public void setRelated_ids(ArrayList<RelatedIdModel> related_ids) {
        this.related_ids = related_ids;
    }*/

    public ArrayList getUpsell_ids() {
        return upsell_ids;
    }

    public void setUpsell_ids(ArrayList upsell_ids) {
        this.upsell_ids = upsell_ids;
    }

    public ArrayList getCross_sell_ids() {
        return cross_sell_ids;
    }

    public void setCross_sell_ids(ArrayList cross_sell_ids) {
        this.cross_sell_ids = cross_sell_ids;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public String getPurchase_note() {
        return purchase_note;
    }

    public void setPurchase_note(String purchase_note) {
        this.purchase_note = purchase_note;
    }

    public ArrayList<CategoryModel> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<CategoryModel> categories) {
        this.categories = categories;
    }

    public ArrayList<TagsModel> getTags() {
        return tags;
    }

    public void setTags(ArrayList<TagsModel> tags) {
        this.tags = tags;
    }

    public ArrayList<ImagesModel> getImages() {
        return images;
    }

    public void setImages(ArrayList<ImagesModel> images) {
        this.images = images;
    }

    public ArrayList getAttributes() {
        return attributes;
    }

    public void setAttributes(ArrayList attributes) {
        this.attributes = attributes;
    }

    public ArrayList getDefault_attributes() {
        return default_attributes;
    }

    public void setDefault_attributes(ArrayList default_attributes) {
        this.default_attributes = default_attributes;
    }

    public ArrayList getVariations() {
        return variations;
    }

    public void setVariations(ArrayList variations) {
        this.variations = variations;
    }

    public ArrayList getGrouped_products() {
        return grouped_products;
    }

    public void setGrouped_products(ArrayList grouped_products) {
        this.grouped_products = grouped_products;
    }

    public int getMenu_order() {
        return menu_order;
    }

    public void setMenu_order(int menu_order) {
        this.menu_order = menu_order;
    }

  /*  public ArrayList<MetaDataModel> getMeta_data() {
        return meta_data;
    }

    public void setMeta_data(ArrayList<MetaDataModel> meta_data) {
        this.meta_data = meta_data;
    }
*/
    public LinkModel get_links() {
        return _links;
    }

    public void set_links(LinkModel _links) {
        this._links = _links;
    }

    private LinkModel _links;




}
