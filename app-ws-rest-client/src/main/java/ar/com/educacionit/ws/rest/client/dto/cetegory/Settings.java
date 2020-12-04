
package ar.com.educacionit.ws.rest.client.dto.cetegory;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "adult_content",
    "buying_allowed",
    "buying_modes",
    "catalog_domain",
    "coverage_areas",
    "currencies",
    "fragile",
    "immediate_payment",
    "item_conditions",
    "items_reviews_allowed",
    "listing_allowed",
    "max_description_length",
    "max_pictures_per_item",
    "max_pictures_per_item_var",
    "max_sub_title_length",
    "max_title_length",
    "maximum_price",
    "minimum_price",
    "mirror_category",
    "mirror_master_category",
    "mirror_slave_categories",
    "price",
    "reservation_allowed",
    "restrictions",
    "rounded_address",
    "seller_contact",
    "shipping_modes",
    "shipping_options",
    "shipping_profile",
    "show_contact_information",
    "simple_shipping",
    "stock",
    "sub_vertical",
    "subscribable",
    "tags",
    "vertical",
    "vip_subdomain",
    "buyer_protection_programs",
    "status"
})
public class Settings {

    @JsonProperty("adult_content")
    private Boolean adultContent;
    @JsonProperty("buying_allowed")
    private Boolean buyingAllowed;
    @JsonProperty("buying_modes")
    private List<String> buyingModes = null;
    @JsonProperty("catalog_domain")
    private String catalogDomain;
    @JsonProperty("coverage_areas")
    private String coverageAreas;
    @JsonProperty("currencies")
    private List<String> currencies = null;
    @JsonProperty("fragile")
    private Boolean fragile;
    @JsonProperty("immediate_payment")
    private String immediatePayment;
    @JsonProperty("item_conditions")
    private List<String> itemConditions = null;
    @JsonProperty("items_reviews_allowed")
    private Boolean itemsReviewsAllowed;
    @JsonProperty("listing_allowed")
    private Boolean listingAllowed;
    @JsonProperty("max_description_length")
    private Integer maxDescriptionLength;
    @JsonProperty("max_pictures_per_item")
    private Integer maxPicturesPerItem;
    @JsonProperty("max_pictures_per_item_var")
    private Integer maxPicturesPerItemVar;
    @JsonProperty("max_sub_title_length")
    private Integer maxSubTitleLength;
    @JsonProperty("max_title_length")
    private Integer maxTitleLength;
    @JsonProperty("maximum_price")
    private Object maximumPrice;
    @JsonProperty("minimum_price")
    private Integer minimumPrice;
    @JsonProperty("mirror_category")
    private Object mirrorCategory;
    @JsonProperty("mirror_master_category")
    private Object mirrorMasterCategory;
    @JsonProperty("mirror_slave_categories")
    private List<Object> mirrorSlaveCategories = null;
    @JsonProperty("price")
    private String price;
    @JsonProperty("reservation_allowed")
    private String reservationAllowed;
    @JsonProperty("restrictions")
    private List<Object> restrictions = null;
    @JsonProperty("rounded_address")
    private Boolean roundedAddress;
    @JsonProperty("seller_contact")
    private String sellerContact;
    @JsonProperty("shipping_modes")
    private List<String> shippingModes = null;
    @JsonProperty("shipping_options")
    private List<String> shippingOptions = null;
    @JsonProperty("shipping_profile")
    private String shippingProfile;
    @JsonProperty("show_contact_information")
    private Boolean showContactInformation;
    @JsonProperty("simple_shipping")
    private String simpleShipping;
    @JsonProperty("stock")
    private String stock;
    @JsonProperty("sub_vertical")
    private String subVertical;
    @JsonProperty("subscribable")
    private Boolean subscribable;
    @JsonProperty("tags")
    private List<Object> tags = null;
    @JsonProperty("vertical")
    private String vertical;
    @JsonProperty("vip_subdomain")
    private String vipSubdomain;
    @JsonProperty("buyer_protection_programs")
    private List<Object> buyerProtectionPrograms = null;
    @JsonProperty("status")
    private String status;

    @JsonProperty("adult_content")
    public Boolean getAdultContent() {
        return adultContent;
    }

    @JsonProperty("adult_content")
    public void setAdultContent(Boolean adultContent) {
        this.adultContent = adultContent;
    }

    @JsonProperty("buying_allowed")
    public Boolean getBuyingAllowed() {
        return buyingAllowed;
    }

    @JsonProperty("buying_allowed")
    public void setBuyingAllowed(Boolean buyingAllowed) {
        this.buyingAllowed = buyingAllowed;
    }

    @JsonProperty("buying_modes")
    public List<String> getBuyingModes() {
        return buyingModes;
    }

    @JsonProperty("buying_modes")
    public void setBuyingModes(List<String> buyingModes) {
        this.buyingModes = buyingModes;
    }

    @JsonProperty("catalog_domain")
    public String getCatalogDomain() {
        return catalogDomain;
    }

    @JsonProperty("catalog_domain")
    public void setCatalogDomain(String catalogDomain) {
        this.catalogDomain = catalogDomain;
    }

    @JsonProperty("coverage_areas")
    public String getCoverageAreas() {
        return coverageAreas;
    }

    @JsonProperty("coverage_areas")
    public void setCoverageAreas(String coverageAreas) {
        this.coverageAreas = coverageAreas;
    }

    @JsonProperty("currencies")
    public List<String> getCurrencies() {
        return currencies;
    }

    @JsonProperty("currencies")
    public void setCurrencies(List<String> currencies) {
        this.currencies = currencies;
    }

    @JsonProperty("fragile")
    public Boolean getFragile() {
        return fragile;
    }

    @JsonProperty("fragile")
    public void setFragile(Boolean fragile) {
        this.fragile = fragile;
    }

    @JsonProperty("immediate_payment")
    public String getImmediatePayment() {
        return immediatePayment;
    }

    @JsonProperty("immediate_payment")
    public void setImmediatePayment(String immediatePayment) {
        this.immediatePayment = immediatePayment;
    }

    @JsonProperty("item_conditions")
    public List<String> getItemConditions() {
        return itemConditions;
    }

    @JsonProperty("item_conditions")
    public void setItemConditions(List<String> itemConditions) {
        this.itemConditions = itemConditions;
    }

    @JsonProperty("items_reviews_allowed")
    public Boolean getItemsReviewsAllowed() {
        return itemsReviewsAllowed;
    }

    @JsonProperty("items_reviews_allowed")
    public void setItemsReviewsAllowed(Boolean itemsReviewsAllowed) {
        this.itemsReviewsAllowed = itemsReviewsAllowed;
    }

    @JsonProperty("listing_allowed")
    public Boolean getListingAllowed() {
        return listingAllowed;
    }

    @JsonProperty("listing_allowed")
    public void setListingAllowed(Boolean listingAllowed) {
        this.listingAllowed = listingAllowed;
    }

    @JsonProperty("max_description_length")
    public Integer getMaxDescriptionLength() {
        return maxDescriptionLength;
    }

    @JsonProperty("max_description_length")
    public void setMaxDescriptionLength(Integer maxDescriptionLength) {
        this.maxDescriptionLength = maxDescriptionLength;
    }

    @JsonProperty("max_pictures_per_item")
    public Integer getMaxPicturesPerItem() {
        return maxPicturesPerItem;
    }

    @JsonProperty("max_pictures_per_item")
    public void setMaxPicturesPerItem(Integer maxPicturesPerItem) {
        this.maxPicturesPerItem = maxPicturesPerItem;
    }

    @JsonProperty("max_pictures_per_item_var")
    public Integer getMaxPicturesPerItemVar() {
        return maxPicturesPerItemVar;
    }

    @JsonProperty("max_pictures_per_item_var")
    public void setMaxPicturesPerItemVar(Integer maxPicturesPerItemVar) {
        this.maxPicturesPerItemVar = maxPicturesPerItemVar;
    }

    @JsonProperty("max_sub_title_length")
    public Integer getMaxSubTitleLength() {
        return maxSubTitleLength;
    }

    @JsonProperty("max_sub_title_length")
    public void setMaxSubTitleLength(Integer maxSubTitleLength) {
        this.maxSubTitleLength = maxSubTitleLength;
    }

    @JsonProperty("max_title_length")
    public Integer getMaxTitleLength() {
        return maxTitleLength;
    }

    @JsonProperty("max_title_length")
    public void setMaxTitleLength(Integer maxTitleLength) {
        this.maxTitleLength = maxTitleLength;
    }

    @JsonProperty("maximum_price")
    public Object getMaximumPrice() {
        return maximumPrice;
    }

    @JsonProperty("maximum_price")
    public void setMaximumPrice(Object maximumPrice) {
        this.maximumPrice = maximumPrice;
    }

    @JsonProperty("minimum_price")
    public Integer getMinimumPrice() {
        return minimumPrice;
    }

    @JsonProperty("minimum_price")
    public void setMinimumPrice(Integer minimumPrice) {
        this.minimumPrice = minimumPrice;
    }

    @JsonProperty("mirror_category")
    public Object getMirrorCategory() {
        return mirrorCategory;
    }

    @JsonProperty("mirror_category")
    public void setMirrorCategory(Object mirrorCategory) {
        this.mirrorCategory = mirrorCategory;
    }

    @JsonProperty("mirror_master_category")
    public Object getMirrorMasterCategory() {
        return mirrorMasterCategory;
    }

    @JsonProperty("mirror_master_category")
    public void setMirrorMasterCategory(Object mirrorMasterCategory) {
        this.mirrorMasterCategory = mirrorMasterCategory;
    }

    @JsonProperty("mirror_slave_categories")
    public List<Object> getMirrorSlaveCategories() {
        return mirrorSlaveCategories;
    }

    @JsonProperty("mirror_slave_categories")
    public void setMirrorSlaveCategories(List<Object> mirrorSlaveCategories) {
        this.mirrorSlaveCategories = mirrorSlaveCategories;
    }

    @JsonProperty("price")
    public String getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(String price) {
        this.price = price;
    }

    @JsonProperty("reservation_allowed")
    public String getReservationAllowed() {
        return reservationAllowed;
    }

    @JsonProperty("reservation_allowed")
    public void setReservationAllowed(String reservationAllowed) {
        this.reservationAllowed = reservationAllowed;
    }

    @JsonProperty("restrictions")
    public List<Object> getRestrictions() {
        return restrictions;
    }

    @JsonProperty("restrictions")
    public void setRestrictions(List<Object> restrictions) {
        this.restrictions = restrictions;
    }

    @JsonProperty("rounded_address")
    public Boolean getRoundedAddress() {
        return roundedAddress;
    }

    @JsonProperty("rounded_address")
    public void setRoundedAddress(Boolean roundedAddress) {
        this.roundedAddress = roundedAddress;
    }

    @JsonProperty("seller_contact")
    public String getSellerContact() {
        return sellerContact;
    }

    @JsonProperty("seller_contact")
    public void setSellerContact(String sellerContact) {
        this.sellerContact = sellerContact;
    }

    @JsonProperty("shipping_modes")
    public List<String> getShippingModes() {
        return shippingModes;
    }

    @JsonProperty("shipping_modes")
    public void setShippingModes(List<String> shippingModes) {
        this.shippingModes = shippingModes;
    }

    @JsonProperty("shipping_options")
    public List<String> getShippingOptions() {
        return shippingOptions;
    }

    @JsonProperty("shipping_options")
    public void setShippingOptions(List<String> shippingOptions) {
        this.shippingOptions = shippingOptions;
    }

    @JsonProperty("shipping_profile")
    public String getShippingProfile() {
        return shippingProfile;
    }

    @JsonProperty("shipping_profile")
    public void setShippingProfile(String shippingProfile) {
        this.shippingProfile = shippingProfile;
    }

    @JsonProperty("show_contact_information")
    public Boolean getShowContactInformation() {
        return showContactInformation;
    }

    @JsonProperty("show_contact_information")
    public void setShowContactInformation(Boolean showContactInformation) {
        this.showContactInformation = showContactInformation;
    }

    @JsonProperty("simple_shipping")
    public String getSimpleShipping() {
        return simpleShipping;
    }

    @JsonProperty("simple_shipping")
    public void setSimpleShipping(String simpleShipping) {
        this.simpleShipping = simpleShipping;
    }

    @JsonProperty("stock")
    public String getStock() {
        return stock;
    }

    @JsonProperty("stock")
    public void setStock(String stock) {
        this.stock = stock;
    }

    @JsonProperty("sub_vertical")
    public String getSubVertical() {
        return subVertical;
    }

    @JsonProperty("sub_vertical")
    public void setSubVertical(String subVertical) {
        this.subVertical = subVertical;
    }

    @JsonProperty("subscribable")
    public Boolean getSubscribable() {
        return subscribable;
    }

    @JsonProperty("subscribable")
    public void setSubscribable(Boolean subscribable) {
        this.subscribable = subscribable;
    }

    @JsonProperty("tags")
    public List<Object> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    @JsonProperty("vertical")
    public String getVertical() {
        return vertical;
    }

    @JsonProperty("vertical")
    public void setVertical(String vertical) {
        this.vertical = vertical;
    }

    @JsonProperty("vip_subdomain")
    public String getVipSubdomain() {
        return vipSubdomain;
    }

    @JsonProperty("vip_subdomain")
    public void setVipSubdomain(String vipSubdomain) {
        this.vipSubdomain = vipSubdomain;
    }

    @JsonProperty("buyer_protection_programs")
    public List<Object> getBuyerProtectionPrograms() {
        return buyerProtectionPrograms;
    }

    @JsonProperty("buyer_protection_programs")
    public void setBuyerProtectionPrograms(List<Object> buyerProtectionPrograms) {
        this.buyerProtectionPrograms = buyerProtectionPrograms;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

}
