/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nurul.action;

import com.nurul.dao.mhsDao;
import com.nurul.dao.mhsDaoImpl;
import com.nurul.model.Mahasiswa;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author nurul apriyani
 */
public class mhsAction extends ActionSupport {
    private ArrayList<Mahasiswa> listmhs= new ArrayList<Mahasiswa>();;
    private mhsDaoImpl mhsdao;
    private Mahasiswa mhs= new Mahasiswa();
    private List<String> listjk;
    private String action;
    private String msg;
   
    public mhsAction(){
        mhsdao= new mhsDaoImpl();
    }
    public String Listmhs(){
        this.listmhs=  mhsdao.getListmhs();
        return SUCCESS;
    }
     public String addmhs(){
        if(action!=null)
        {
            mhsdao.insert(getMhs());
            msg="1 record added";
        }
        return SUCCESS;
    }
     public String deletemhs(){
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
        mhsdao.delete(Integer.parseInt(request.getParameter("id")));
        return SUCCESS;
    }
     public String editmhs(){
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
        if (action!=null)
        {
            mhsdao.update(getMhs());
            msg="1 record edited";
        }
        else mhs= mhsdao.getMhsById(Integer.parseInt(request.getParameter("id")));
        return SUCCESS;
    }
     
    public ArrayList<Mahasiswa> getListmhs(){
        return this.listmhs ;
    }
    public Mahasiswa getMhs(){
        return this.mhs;
    }
    public void setMhs(Mahasiswa mhs){
        this.mhs=mhs;
    }
    public void setAction(String action){
        this.action=action;
    }
    public String getMsg()
    {
        return this.msg;
    }
}
