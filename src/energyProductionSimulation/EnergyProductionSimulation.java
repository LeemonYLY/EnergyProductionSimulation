package energyProductionSimulation;

public class EnergyProductionSimulation {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Please provide 2 double values as command-line arguments.");
			return;
		}

		double energyProduced = Double.parseDouble(args[0]);
		double energyConsumed = Double.parseDouble(args[1]);

		double netEnergy = func1(energyProduced, energyConsumed);
		double energyEfficiency = func2(energyProduced, energyConsumed);
		double energyDensity = func3(energyProduced);
		double finalResult = func4(netEnergy, energyEfficiency, energyDensity);

		finalResult = Math.round(finalResult * 100) * 1.0 / 100;
		System.out.println(finalResult);
	}

	// Function to calculate net energy (energy produced - energy consumed)
	public static double func1(double energyProduced, double energyConsumed) {
		double netEnergy1 = energyProduced * Math.log(energyConsumed);
		double netEnergy2 = energyConsumed * Math.log(energyProduced);
		return (netEnergy1 - netEnergy2) % 100000;
	}

	// Function to calculate energy efficiency based on energy produced and consumed
	public static double func2(double energyProduced, double energyConsumed) {
		// Energy Efficiency = (Energy Produced / Energy Consumed) * 100
		double energyEfficiency = (energyProduced / energyConsumed) * 100;
		return energyEfficiency % 100000;
	}

	// Function to calculate energy density based on energy produced
	public static double func3(double energyProduced) {
		// Energy Density = Energy Produced / Volume
		double volume = 10; // Volume in cubic meters

		double energyDensity = energyProduced / volume * Math.exp((energyProduced / volume) % 5.2);
		return energyDensity % 100000;
	}

	// Function to calculate a combined value based on net energy, energy
	// efficiency, and energy density
	public static double func4(double netEnergy, double energyEfficiency, double energyDensity) {
		// Example combined value: (net energy * energy efficiency) / energy density
		double finalResult = (netEnergy * energyEfficiency) / energyDensity;
		return finalResult % 100000;
	}
}
