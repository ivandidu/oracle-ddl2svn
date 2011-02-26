package ru.qwazer.scheme2ddl.worker;

import ru.qwazer.scheme2ddl.beans.UserObject;
import ru.qwazer.scheme2ddl.dao.IDao;
import ru.qwazer.scheme2ddl.filework.IFileWorker;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Reshetnikov AV resheto@gmail.com
 * Date: 20.02.11
 * Time: 18:21
 */
public class Worker {

    private IDao dao;
    private IFileWorker fileWorker;


    public void work() {
        System.out.println("start getting of user object list for processing");
        List<UserObject> list = dao.getUserObjectList();
        System.out.println("get " + list.size() + " objects");
        for (UserObject obj : list){
            obj = dao.fillDDL(obj);
            fileWorker.save2file(obj);
        }
        System.out.println(" done " );
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }

    public void setFileWorker(IFileWorker fileWorker) {
        this.fileWorker = fileWorker;
    }

    public IDao getDao() {
        return dao;
    }

    public IFileWorker getFileWorker() {
        return fileWorker;
    }
}