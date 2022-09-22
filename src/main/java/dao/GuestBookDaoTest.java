package dao;

import config.ApplicationConfig;
import dto.Log;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

public class GuestBookDaoTest {
    public static void main(String[] args) {;
        ApplicationContext ac=new AnnotationConfigApplicationContext(ApplicationConfig.class);
    //        GuestbookDAO guestBookDao=ac.getBean(GuestbookDAO.class);
    //
    //        Guestbook guestbook=new Guestbook();
    //        guestbook.setName("주동호");
    //        guestbook.setContent("안녕하세요 테스트입니다");
    //        guestbook.setRegdate((new Date()));
    //        Long id= guestBookDao.insert(guestbook);
    //        System.out.println("ID:"+id);
        LogDAO logDAO=ac.getBean(LogDAO.class);
        Log log=new Log();
        log.setIp("127.0.0.1");
        log.setMethod("insert");
        log.setRegdate(new Date());
        logDAO.insert(log);
    }
}
