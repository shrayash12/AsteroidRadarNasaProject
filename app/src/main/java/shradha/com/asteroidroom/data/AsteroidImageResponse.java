
package shradha.com.asteroidroom.data;


public class AsteroidImageResponse {

    @com.squareup.moshi.Json(name = "copyright")
    private String copyright;
    @com.squareup.moshi.Json(name = "date")
    private String date;
    @com.squareup.moshi.Json(name = "explanation")
    private String explanation;
    @com.squareup.moshi.Json(name = "hdurl")
    private String hdurl;
    @com.squareup.moshi.Json(name = "media_type")
    private String mediaType;
    @com.squareup.moshi.Json(name = "service_version")
    private String serviceVersion;
    @com.squareup.moshi.Json(name = "title")
    private String title;
    @com.squareup.moshi.Json(name = "url")
    private String url;

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getHdurl() {
        return hdurl;
    }

    public void setHdurl(String hdurl) {
        this.hdurl = hdurl;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getServiceVersion() {
        return serviceVersion;
    }

    public void setServiceVersion(String serviceVersion) {
        this.serviceVersion = serviceVersion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
