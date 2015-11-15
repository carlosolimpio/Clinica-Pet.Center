package clinica.pet_center.negocio.basicas;

public class TesteClassesBasicas {

	public static void main(String[] args) {
		Cirurgia cir1 = new Cirurgia("01CIR", "Cardiaca", "09/11/2015", null, null, null);
		
		System.out.println(cir1.toString());
		
		SolicitacaoCirurgica scir1 = new SolicitacaoCirurgica(null, cir1.getCodigoCirurgia(),
				"10/11/2015", "Necessidade de medir as forças do coração");
		
		System.out.println(scir1.toString());
		
		IntervencaoCirurgica icir1 = new IntervencaoCirurgica("01EQPMED", cir1.getCodigoCirurgia(), null, null);
		
		System.out.println(icir1.toString());
		
		EquipeMedica eqm1 = new EquipeMedica("MDR01", "Cirurgião Geral", icir1.getCodCirurgia());
		
		System.out.println(eqm1.toString());
	}

}
