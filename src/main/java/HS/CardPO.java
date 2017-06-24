package HS;

import javax.persistence.*;

/**
 * Created by Николай on 16.08.2016.
 */
@Entity
@Table(name = "CARD")
public class CardPO {
    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "NAME")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "nation")
    private String nation;
    @Column(name = "gameClass")
    private String gameClass;
    @Column(name = "cost")
    private Integer cost;
    @Column(name = "attack")
    private Integer attack;
    @Column(name = "health")
    private Integer health;
    @Column(name = "type")
    private String type;
    @Column(name = "pack")
    private String pack;
    @Column(name = "redkost")
    private String redkost;
    @Column(name = "popular")
    private Integer popular;

    public CardPO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getGameClass() {
        return gameClass;
    }

    public void setGameClass(String gameClass) {
        this.gameClass = gameClass;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPack() {
        return pack;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }

    public String getRedkost() {
        return redkost;
    }

    public void setRedkost(String redkost) {
        this.redkost = redkost;
    }

    public Integer getPopular() {
        return popular;
    }

    public void setPopular(Integer popular) {
        this.popular = popular;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardPO cardPO = (CardPO) o;

        if (id != null ? !id.equals(cardPO.id) : cardPO.id != null) return false;
        if (name != null ? !name.equals(cardPO.name) : cardPO.name != null) return false;
        if (description != null ? !description.equals(cardPO.description) : cardPO.description != null) return false;
        if (nation != null ? !nation.equals(cardPO.nation) : cardPO.nation != null) return false;
        if (gameClass != null ? !gameClass.equals(cardPO.gameClass) : cardPO.gameClass != null) return false;
        if (cost != null ? !cost.equals(cardPO.cost) : cardPO.cost != null) return false;
        if (attack != null ? !attack.equals(cardPO.attack) : cardPO.attack != null) return false;
        if (health != null ? !health.equals(cardPO.health) : cardPO.health != null) return false;
        if (type != null ? !type.equals(cardPO.type) : cardPO.type != null) return false;
        if (pack != null ? !pack.equals(cardPO.pack) : cardPO.pack != null) return false;
        if (redkost != null ? !redkost.equals(cardPO.redkost) : cardPO.redkost != null) return false;
        return !(popular != null ? !popular.equals(cardPO.popular) : cardPO.popular != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (nation != null ? nation.hashCode() : 0);
        result = 31 * result + (gameClass != null ? gameClass.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (attack != null ? attack.hashCode() : 0);
        result = 31 * result + (health != null ? health.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (pack != null ? pack.hashCode() : 0);
        result = 31 * result + (redkost != null ? redkost.hashCode() : 0);
        result = 31 * result + (popular != null ? popular.hashCode() : 0);
        return result;
    }
}
