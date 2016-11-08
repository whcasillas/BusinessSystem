package com.hisun.action.upAndDown;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hisun.DAO.upDown.DataDao;
import com.hisun.bean.FileItem;
import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction extends ActionSupport
{

    /**
     * serialVersionUID:TODO（用一句话描述这个变量表示什么）
     *
     * @since Ver 1.1
     */
    private static final long serialVersionUID = 1L;
    
    private DataDao dao=new DataDao();
    private List<FileItem>list;
    private String fileId;    
    private FileItem fileItem;
    
    //获得list
    public String list() throws Exception
    {
    	HttpServletRequest request = ServletActionContext.getRequest();
    	String fileId = request.getParameter("fileId");
    	String[] file_id = fileId.split(",");
        list=dao.getFileList(file_id);
        return "list-success";
    }
    //获得文件
    public String get() throws Exception
    {
        fileItem=dao.getFileItem(fileId);
        return "get-success";
    }
    
    //获得输入流
    public InputStream getInputStream()
    {
        try
        {
            //String path=ServletActionContext.getServletContext().getRealPath("/");
            String fileName=fileItem.getFile_path();
            FileInputStream fis=new FileInputStream(fileName);
            return fis;
        }
        catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    //获得文件类型
    public String getFile_type()
    {
        return fileItem.getFile_type();
    }
    
    //获得文件下载位置
    public String getContentDisposition()
    {
        try
        {
        	String fn = fileItem.getFile_name();
            return "attachment;filename="+URLEncoder.encode(fn,"UTF-8");
        }
        catch (UnsupportedEncodingException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    //获得文件字节大小
    public String getFile_length()
    {
        return fileItem.getFile_length();
    }
    
    
    public List<FileItem> getList()
    {
        return list;
    }

    public void setList(List<FileItem> list)
    {
        this.list = list;
    }
    public String getFileId()
    {
        return fileId;
    }
    public void setFileId(String fileId)
    {
        this.fileId = fileId;
    }
    

}
