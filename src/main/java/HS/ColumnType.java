package HS;

/**
 * Created by Николай on 09.08.2016.
 */
public enum ColumnType {
    //Name + description
    NAME_TEXT(2),
    NATION(4),
    GAME_CLASS(5),
    COST(6),
    ATTACK(7),
    HEALTH(8),
    PACK_TYPE(9),
    REDCOST(10),
    POPULAR(11);

    private int columnNumber;

    ColumnType(int columnNumber) {
        this.columnNumber = columnNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public static ColumnType find(int number){
        for (ColumnType columnType : ColumnType.values()) {
            if (columnType.getColumnNumber() == number) {
                return columnType;
            }

        }
        return null;
    }
}
