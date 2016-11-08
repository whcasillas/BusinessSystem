package com.hisun.action.upAndDown;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.hisun.DAO.upDown.DataDao;
import com.hisun.bean.FileItem;
import com.hisun.bean.staff.StaffBean;
import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport
{

    /**
     * serialVersionUID:TODO（用一句话描述这个变量表示什么）
     *
     * @since Ver 1.1
     */
    private static final long serialVersionUID = 1L;
    
    private List<File>image;
    private List<String>imageContentType;
    private List<String>imageFileName;
    
    @Override
    public String execute() throws Exception
    {	
    	HttpServletRequest request = ServletActionContext.getRequest();
    	DataDao dao = new DataDao();
        String path=ServletActionContext.getServletContext().getRealPath("/upload");
        System.out.println("保存路径为"+path);
        
        if (image.size()>0)
        {
            File savedir=new File(path);
            if(!savedir.exists()) savedir.mkdirs(); 
            for (int i = 0; i < image.size(); i++)
            {
                System.out.println("datas的个数"+image.size());
                
                String fn = imageFileName.get(i);
                String[] fname = fn.split("\\.");
            	String filename = fname[0] + "_" + dao.getTime() + "." + fname[1];
            	
                File saveFile=new File(savedir, filename);
                
                FileUtils.copyFile(image.get(i), saveFile);
                FileItem f = new FileItem();
                f.setFile_name(filename);
                f.setFile_length(String.valueOf(saveFile.length()));
                f.setFile_path(saveFile.getPath());
                StaffBean bean = (StaffBean)request.getSession().getAttribute("STAFFINFO");
                f.setUpdate_staff(bean.getStaff_name());
                f.setFile_type(fname[1]);
                
                dao.saveFileInfo(f);
            }
        }else {
            System.out.println("datas为空");
        }
        
//        for (int i = 0; i < image.size(); i++)
//        {
//            File data=image.get(i);
//            String fileName=imageFileName.get(i);
//            fileName=path+"\\"+fileName;
//            data.renameTo(new File(fileName));
//        }
        return SUCCESS;
    }

    public List<File> getImage()
    {
        return image;
    }

    public void setImage(List<File> image)
    {
        this.image = image;
    }

    public List<String> getImageContentType()
    {
        return imageContentType;
    }

    public void setImageContentType(List<String> imageContentType)
    {
        this.imageContentType = imageContentType;
    }

    public List<String> getImageFileName()
    {
        return imageFileName;
    }

    public void setImageFileName(List<String> imageFileName)
    {
        this.imageFileName = imageFileName;
    }
    
    
    

}
