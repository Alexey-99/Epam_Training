package by.koroza.array.service;

public interface ServiceArrayReplacement {

	public double[] replacingNegativeNumbersWith(double[] array, double insertedElement);

	public double[] replacingPositiveNumbersWith(double[] array, double insertedElement);

	public double[] replacingEvenNumbersWith(double[] array, double insertedElement);

	public double[] replacingOddNumbersWith(double[] array, double insertedElement);

	public double[] replacingNumberWith(double[] array, double replacingElement, double insertedElement);
}