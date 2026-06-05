package com.zhangsan.edu.mock;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import java.sql.SQLException;

public class CodeGen {
   public static void main(String[] args) throws SQLException {
      AutoGenerator mpg = new AutoGenerator();
      GlobalConfig gc = new GlobalConfig();
      gc.setOutputDir("D:\\work4ideaBD2020\\gmall2020-mock\\edu2021-mock-log\\src\\main\\java");
      gc.setFileOverride(true);
      gc.setActiveRecord(false);
      gc.setEnableCache(false);
      gc.setBaseResultMap(false);
      gc.setBaseColumnList(false);
      gc.setAuthor("zhangchen");
      gc.setServiceName("%sService");
      gc.setServiceImplName("%sServiceImpl");
      gc.setMapperName("%sMapper");
      gc.setXmlName("%sMapper");
      gc.setDateType(DateType.ONLY_DATE);
      mpg.setGlobalConfig(gc);
      DataSourceConfig dsc = new DataSourceConfig();
      dsc.setDbType(DbType.MYSQL);
      dsc.setDriverName("com.mysql.jdbc.Driver");
      dsc.setUsername("root");
      dsc.setPassword("000000");
      dsc.setUrl("jdbc:mysql://81.70.194.50:3306/yuntai_sys");
      mpg.setDataSource(dsc);
      StrategyConfig strategy = new StrategyConfig();
      strategy.setNaming(NamingStrategy.underline_to_camel);
      strategy.setInclude(new String[]{"t_ds_user"});
      strategy.setSuperServiceClass("cn.false2true.mock.service.adv.AdvService");
      strategy.setSuperServiceImplClass("cn.false2true.mock.service.adv.impl.AdvServiceImpl");
      mpg.setStrategy(strategy);
      PackageConfig pc = new PackageConfig();
      pc.setParent("cn.false2true.yuntai.govern");
      pc.setService("service");
      pc.setServiceImpl("service.impl");
      pc.setMapper("mapper");
      pc.setEntity("bean");
      mpg.setPackageInfo(pc);
      mpg.execute();
   }
}
