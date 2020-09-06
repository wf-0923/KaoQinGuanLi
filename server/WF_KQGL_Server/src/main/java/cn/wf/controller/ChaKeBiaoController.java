package cn.wf.controller;

import cn.wf.dao.MineDao;
import cn.wf.pojo.KeBiao;
import cn.wf.service.ChaKeBiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping
public class ChaKeBiaoController {

    @Autowired
    private ChaKeBiaoService chaKeBiaoService;
    @Autowired
    private MineDao mineDao;

    @RequestMapping("chakebiao")
    public String chakebiao(Model modelchakebiao, HttpSession session) {
        String username = (String) session.getAttribute("loginsuccess");
        String name = mineDao.chaxunyidengluyonghujibenziliao(username).getName();
        List<KeBiao> kebiaolist = chaKeBiaoService.chakebiao(username);
        modelchakebiao.addAttribute("kebiao", kebiaolist);
        System.out.println(modelchakebiao);
        return "kebiao/kebiao";
    }

}
