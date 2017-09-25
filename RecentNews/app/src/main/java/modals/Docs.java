package modals;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
/**
 * Awesome Pojo Generator
 * */
public class Docs{
  @SerializedName("snippet")
  @Expose
  private String snippet;
  @SerializedName("keywords")
  @Expose
  private List<Keywords> keywords;
  @SerializedName("new_desk")
  @Expose
  private String new_desk;
  @SerializedName("source")
  @Expose
  private String source;
  @SerializedName("blog")
  @Expose
  private Blog blog;
  @SerializedName("uri")
  @Expose
  private String uri;
  @SerializedName("pub_date")
  @Expose
  private String pub_date;
  @SerializedName("score")
  @Expose
  private Integer score;
  @SerializedName("multimedia")
  @Expose
  private List<Multimedia> multimedia;
  @SerializedName("word_count")
  @Expose
  private Integer word_count;
  @SerializedName("type_of_material")
  @Expose
  private String type_of_material;
  @SerializedName("web_url")
  @Expose
  private String web_url;
  @SerializedName("_id")
  @Expose
  private String _id;
  @SerializedName("headline")
  @Expose
  private Headline headline;
  @SerializedName("byline")
  @Expose
  private Byline byline;
  @SerializedName("document_type")
  @Expose
  private String document_type;
  public void setSnippet(String snippet){
   this.snippet=snippet;
  }
  public String getSnippet(){
   return snippet;
  }
  public void setKeywords(List<Keywords> keywords){
   this.keywords=keywords;
  }
  public List<Keywords> getKeywords(){
   return keywords;
  }
  public void setNew_desk(String new_desk){
   this.new_desk=new_desk;
  }
  public String getNew_desk(){
   return new_desk;
  }
  public void setSource(String source){
   this.source=source;
  }
  public String getSource(){
   return source;
  }
  public void setBlog(Blog blog){
   this.blog=blog;
  }
  public Blog getBlog(){
   return blog;
  }
  public void setUri(String uri){
   this.uri=uri;
  }
  public String getUri(){
   return uri;
  }
  public void setPub_date(String pub_date){
   this.pub_date=pub_date;
  }
  public String getPub_date(){
   return pub_date;
  }
  public void setScore(Integer score){
   this.score=score;
  }
  public Integer getScore(){
   return score;
  }
  public void setMultimedia(List<Multimedia> multimedia){
   this.multimedia=multimedia;
  }
  public List<Multimedia> getMultimedia(){
   return multimedia;
  }
  public void setWord_count(Integer word_count){
   this.word_count=word_count;
  }
  public Integer getWord_count(){
   return word_count;
  }
  public void setType_of_material(String type_of_material){
   this.type_of_material=type_of_material;
  }
  public String getType_of_material(){
   return type_of_material;
  }
  public void setWeb_url(String web_url){
   this.web_url=web_url;
  }
  public String getWeb_url(){
   return web_url;
  }
  public void set_id(String _id){
   this._id=_id;
  }
  public String get_id(){
   return _id;
  }
  public void setHeadline(Headline headline){
   this.headline=headline;
  }
  public Headline getHeadline(){
   return headline;
  }
  public void setByline(Byline byline){
   this.byline=byline;
  }
  public Byline getByline(){
   return byline;
  }
  public void setDocument_type(String document_type){
   this.document_type=document_type;
  }
  public String getDocument_type(){
   return document_type;
  }
}