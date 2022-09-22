package service.impl;


import dao.GuestbookDAO;
import dao.LogDAO;
import dto.Guestbook;
import dto.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.GuestbookService;

import java.util.Date;
import java.util.List;

@Service
public class GuestBookServiceImpl implements GuestbookService {
    @Autowired
    GuestbookDAO guestbookDAO;
    @Autowired
    LogDAO logDAO;

    @Override
    @Transactional
    //읽을떄만 사용하는건 이걸 붙혀주면 편함
    public List<Guestbook> getGuestbooks(Integer start){
        List<Guestbook> list=guestbookDAO.selectAll(start,GuestbookService.LIMIT);
        return null;
    }
    @Override
    @Transactional(readOnly = false)
    public int deleteGuestbook(Long id,String ip){
        int deleteCount=guestbookDAO.deleteById(id);
        Log log=new Log();
        log.setIp(ip);
        log.setMethod("delete");
        log.setRegdate(new Date());
        logDAO.insert(log);
        return deleteCount;
    }
    @Override
    @Transactional(readOnly = false)
    public Guestbook addGuestbook(Guestbook guestbook,String ip){
        guestbook.setRegdate(new Date());
        Long id=guestbookDAO.insert(guestbook);
        guestbook.setId(id);

        Log log=new Log();
        log.setIp(ip);
        log.setMethod("insert");
        log.setRegdate(new Date());
        logDAO.insert(log);

        return guestbook;
    }

    @Override
    public int getCount() {
        return guestbookDAO.selectCount();
    }
}
