package struts2.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import struts2.model.UserLoginData;
import struts2.service.CategoryMapper;

@Results({ @Result(name = "success", location = "/chat.jsp"),
		@Result(name = "input", location = "/docchooser.jsp") })
public class ChooseDoctorAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4498264509300085094L;
	private List<String> doccategory;
	private String yourcategory;

	public List<String> getDoccategory() {
		return doccategory;
	}

	public void setDoccategory(List<String> doccategory) {
		this.doccategory = doccategory;
	}

	public ChooseDoctorAction() {
//		TODO get the categories from database 
		doccategory = new ArrayList<String>();
		doccategory.add("general practitioner");
		doccategory.add("ear nose throat doctor");
	}

	public String getDefaultDoccategory() {
		return doccategory.get(0);
	}

	public String getYourcategory() {
		return yourcategory;
	}

	public void setYourcategory(String yourcategory) {
		this.yourcategory = yourcategory;
	}

	@Action(value = "choosedoc")
	public String execute() {
		UserLoginData uld = (UserLoginData) ActionContext.getContext().getSession().get("userlogindata");
		CategoryMapper.addCategory(uld.hashCode(), yourcategory);
		return SUCCESS;
	}

	@Action(value = "prechoosedoc")
	public String display() {
		return INPUT;
	}

}
