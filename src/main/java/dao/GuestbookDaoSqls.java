package dao;

public class GuestbookDaoSqls {
    public static final String SELECT_PAGING="SELECT id,name,content,regdate FROM guestbook FROM " +
                                            "guestbook ORDER BY ID DESC limit:start,:limit";
    public static final String DELETE_BY_ID="DELETE FROM guestbook WHERE id=:id";
    public static final String SELECT_COUNT="SELECT count(*) FROM guestbook";
}
