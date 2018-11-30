package control;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class ImagesView {
     
    private List<String> images;
    private String option;
    
    @PostConstruct
    public void init() {
		images = new ArrayList<>();
    	carregarJogosPS4();
    	carregarJogosXbox();
    	carregarJogosWii();
    }

	private void carregarJogosPS4() {
    	for (int i = 1; i <= 5; i++) {
            images.add("ps4" + i + ".jpg");
        }
	}
 
	private void carregarJogosXbox() {
    	for (int i = 1; i <= 5; i++) {
            images.add("xbox" + i + ".jpg");
        }
	}
	
	
	private void carregarJogosWii() {
    	for (int i = 1; i <= 5; i++) {
            images.add("wii" + i + ".jpg");
        }
	}
    public List<String> getImages() {
        return images;
    }

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		String mensagem="";
		if(option!=null && !option.equals("")) {
			images = new ArrayList<>();

			if(option.equals("Xbox")) {
				carregarJogosXbox();
			}
			else if(option.equals("PS4")) {
				carregarJogosPS4();
			}
			else if(option.equals("Wii")) {
				carregarJogosWii();
			}			
		}else {
			mensagem="Todas selecionadas";
		}
		
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso",mensagem));
		
		this.option = option;
	}
	
    
    
}
