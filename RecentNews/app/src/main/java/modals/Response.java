package modals;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
/**
 * Awesome Pojo Generator
 * */
public class Response{
  @SerializedName("docs")
  @Expose
  private List<Docs> docs;
  @SerializedName("meta")
  @Expose
  private Meta meta;
  public void setDocs(List<Docs> docs){
   this.docs=docs;
  }
  public List<Docs> getDocs(){
   return docs;
  }
  public void setMeta(Meta meta){
   this.meta=meta;
  }
  public Meta getMeta(){
   return meta;
  }
}