
public class Alumno{
	public String nombre;
	public String cedula;
	public byte sexo;
	public byte n_materiasInscritas;
	public byte uc_inscritas;

	public Alumno(
		String nombre,
		String cedula,
		byte sexo,
		byte n_materiasInscritas,
		byte uc_inscritas
		) {
		this.nombre = nombre;
		this.cedula = cedula;
		this.sexo = sexo;
		this.n_materiasInscritas = n_materiasInscritas;
		this.uc_inscritas = uc_inscritas;
	}
	public double calcMontoSemestre() {
		double uc_costo = 150.5;
		double impuestos = 1 + 0.075;
		double descuento1 = 1 - 0.05;
		double descuento2 = 1 - 0.085;
		double total = uc_inscritas * uc_costo * impuestos;
		total *= this.n_materiasInscritas > 3 ? descuento1 : 1;
		total *= total > 2700.0 ? descuento2 : 1;
		return total;
	}
	public String getSexo() {
		return this.sexo == 1? "Masculino": "Femenino";
	}

	public void mostrar(int numero_alumno) {
		MCursor.eqline();

		MCursor.TCen("ALUMNO #" + (numero_alumno + 1));

		MCursor.eqline();

		MCursor.TJus("        NOMBRE = " + this.nombre);
		MCursor.TJus("        CEDULA = " + this.cedula);
		MCursor.TJus("          SEXO = " + this.getSexo());
		MCursor.TJus("   N° MATERIAS = " + this.n_materiasInscritas);
		MCursor.TJus("  UC INSCRITAS = " + this.uc_inscritas);
		MCursor.TJus("COSTO SEMESTRE = " + this.calcMontoSemestre());

		MCursor.eqline();
	}
}