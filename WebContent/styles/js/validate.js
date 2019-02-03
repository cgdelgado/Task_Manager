/**
 * Validate data for create form
 */

function validate(){
	
	var name = document.getElementById('name').value;
	var description = document.getElementById('description').value;
	var start = document.getElementById('start').value;
	var end = document.getElementById('end').value;	
	var validate = 0;
	var err = [];
	
	if(name.length == 0 || name.length >100){
		validate++
		err.push("El nombre es obligatorio y con longitud menor que 100");
	}
	
	if(description.length > 1000){
		validate++
		err.push("Descripción demasiado larga");
	}
	
	if(start.length != 0){		
		date =  Date.parse(start);		
		if(isNaN(date)){
			validate++
			err.push("Formato de fecha de inicio incorrecto");
		}	
	}
	
	if(end.length != 0){		
		date =  Date.parse(end);		
		if(isNaN(date)){
			validate++
			err.push("Formato de fecha fin incorrecto");
		}	
	}
	
	if(start.length != 0 && end.length != 0){
		dateStart =  Date.parse(start);	
		dateEnd =  Date.parse(end);		
		if(!isNaN(dateStart) && !isNaN(dateEnd)){			
			if(dateEnd < dateStart){
				validate++;
				err.push("La fecha de fin no puede ser anterior a la fecha inicio");
			}
		}
		
	}
	
	if(validate > 0){
		alert(err);
		return false;
	}else{
		return true;
	}
	
}