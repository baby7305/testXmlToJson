package com.company.config;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSubjectFactory;

public class StatelessDefaultSubjectFactory extends DefaultWebSubjectFactory {

    /**
     * 第一：SubjectContext在创建的时候，需要关闭session的创建，这个主要是由DefaultWebSubjectFactory的createSubject进行管理。
     */
    @Override
    public Subject createSubject(SubjectContext context) {
        //不进行创建session了.
        context.setSessionCreationEnabled(false);
        return super.createSubject(context);
    }

}
