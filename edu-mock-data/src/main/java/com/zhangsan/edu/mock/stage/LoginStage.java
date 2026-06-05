package com.zhangsan.edu.mock.stage;

import org.springframework.stereotype.Component;

@Component("login")
public class LoginStage implements Stage {
   public boolean handle() {
      return true;
   }
}
