package HS;

/**
 * Created by Николай on 09.08.2016.
 */
public class Card {
    private String name;
    private String description;
    private String nation;
    private String gameClass;
    private Integer cost;
    private Integer attack;
    private Integer health;
    private String type;
    private String pack;
    private String redkost;
    private Integer popular;

    private Card(String name, String pack, String description, String nation, String gameClass, Integer cost, Integer attack, Integer health, String type, String redkost, Integer popular) {
        this.name = name;
        this.pack = pack;
        this.description = description;
        this.nation = nation;
        this.gameClass = gameClass;
        this.cost = cost;
        this.attack = attack;
        this.health = health;
        this.type = type;
        this.redkost = redkost;
        this.popular = popular;
    }

    public String getName() {
        return name;
    }

    public String getPack() {
        return pack;
    }

    public String getDescription() {
        return description;
    }

    public String getNation() {
        return nation;
    }

    public String getGameClass() {
        return gameClass;
    }

    public Integer getCost() {
        return cost;
    }

    public Integer getAttack() {
        return attack;
    }

    public Integer getHealth() {
        return health;
    }

    public String getType() {
        return type;
    }

    public String getRedkost() {
        return redkost;
    }

    public Integer getPopular() {
        return popular;
    }

    public static class CardBuilder {
        private String name;
        private String description;
        private String nation;
        private String gameClass;
        private Integer cost;
        private Integer attack;
        private Integer health;
        private String type;
        private String redkost;
        private Integer popular;
        private String pack;

        public CardBuilder() {
        }

        public void setPack(String pack) {
            this.pack = pack;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setNation(String nation) {
            this.nation = nation;
        }

        public void setGameClass(String gameClass) {
            this.gameClass = gameClass;
        }


        public void setCost(Integer cost) {
            this.cost = cost;
        }


        public void setAttack(Integer attack) {
            this.attack = attack;
        }


        public void setHealth(Integer health) {
            this.health = health;
        }


        public void setType(String type) {
            this.type = type;
        }


        public void setRedkost(String redkost) {
            this.redkost = redkost;
        }


        public void setPopular(Integer popular) {
            this.popular = popular;
        }

        public Card build() {
            return new Card(name, pack, description, nation, gameClass, cost, attack, health, type, redkost, popular);
        }
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", nation='" + nation + '\'' +
                ", gameClass='" + gameClass + '\'' +
                ", cost=" + cost +
                ", attack=" + attack +
                ", health=" + health +
                ", type='" + type + '\'' +
                ", pack='" + pack + '\'' +
                ", redkost='" + redkost + '\'' +
                ", popular=" + popular +
                '}';
    }
}
