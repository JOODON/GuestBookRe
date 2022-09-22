package service.impl;

import config.ApplicationConfig;
import dto.Guestbook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.GuestbookService;

import java.util.Date;

public class GuestBookServiceTest {
    public static void main(String[] args) {
    ApplicationContext ac=new AnnotationConfigApplicationContext(ApplicationConfig.class);
    GuestbookService guestbookService=ac.getBean(GuestbookService.class);
    
    Guestbook guestbook=new Guestbook();
    guestbook.setName("주동호");
    guestbook.setContent("서비스테스트입니다");
    guestbook.setRegdate(new Date());
    Guestbook result=guestbookService.addGuestbook(guestbook,"127.0.0.1");
    System.out.println(result);

    }
}
