package net.fengyu.service;

import lombok.extern.java.Log;
import net.fengyu.config.EnvConfig;
import net.fengyu.dao1.UserDao;
import net.fengyu.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log
@Service
public class DemoService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserDao userDao;

    @Autowired
    private EnvConfig envConfig;


    public String getCurrentProfile() {

        System.out.println("读取到的profile：" + envConfig.getProfile());

//        return "abcd";
        return envConfig.getProfile();
    }


    public boolean visit(User user) {

        if(user != null) {
            StringBuffer sb = new StringBuffer();
            sb.append("visit call.  token=").append(user.getToken())
                    .append(" username=").append(user.getUsrname());

            log.info(sb.toString());
        } else {
            log.warning("User is null!");
            return false;
        }

        return true;
    }

    public boolean insertUser(int userid,String username,String city,int gender) {

        int ret = this.userDao.insertUser( userid, username, city, gender);
        if(ret == 1) {
            return true;
        }
        return false;
    }

}
