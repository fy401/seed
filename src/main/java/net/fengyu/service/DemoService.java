package net.fengyu.service;

import lombok.extern.java.Log;
import net.fengyu.config.EnvConfig;
import net.fengyu.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log
@Service
public class DemoService {

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

}
