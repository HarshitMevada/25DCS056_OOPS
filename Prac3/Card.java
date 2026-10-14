import java.util.Objects;
public class Card {
    private String rank,suit;
    public Card(String rank,String suit){
        this.rank=rank;
        this.suit=suit;
    }
    @Override
    public String toString(){
        return rank+" of "+suit;
    }
    @Override
    public boolean equals(Object obj){
        Card c=(Card)obj;
        if(this.rank.equals(c.rank)&& this.suit.equals(c.suit)){
            return true;
        }
        else{
            return false;
        }
    }
    public int hashCode(){
        return Objects.hash(rank,suit);
    }
}
