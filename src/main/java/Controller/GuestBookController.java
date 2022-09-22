package Controller;

import dto.Guestbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.GuestbookService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GuestBookController {
    @Autowired
    GuestbookService guestbookService;

    @GetMapping(path = "/list")
    public String list(@RequestParam(name = "start",required = false,defaultValue = "0")int start, ModelMap model
    ){
        //start로 시작하는 방명록 구하기
        List<Guestbook> list=guestbookService.getGuestbooks(start);

        //전체 페이지수 구하기
        int count=guestbookService.getCount();
        int pageCount=count/GuestbookService.LIMIT;
        if(count % GuestbookService.LIMIT>0){
            pageCount++;
        }
        List<Integer > pageStartList=new ArrayList<>();
        for (int i=0; i < pageCount; i++){
            pageStartList.add(i*GuestbookService.LIMIT);
        }
        model.addAttribute("list",list);
        model.addAttribute("count",count);
        model.addAttribute("pageStartList",pageStartList);

        return "list";
        }
}
