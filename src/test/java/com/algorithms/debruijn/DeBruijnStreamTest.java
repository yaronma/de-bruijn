package com.algorithms.debruijn;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;

import com.algorithms.base.Tree;
import com.algorithms.debruijn.DeBruijnStream;

public class DeBruijnStreamTest {

	// Test data for valid DeBruijn streams 
	public final TestData[] TESTS = new TestData[] {
			new TestData(4, "0123456789", DeBruijnSquence4_10.data),
			new TestData(6, "01", "0000001000011000101000111001001011001101001111010101110110111111"),
			new TestData(2, "012345", "001020304051121314152232425334354455"),
			new TestData(3, "01234", "00010020030040110120130140210220230240310320330340410420430441112113114122123124132133134142143144222322423323424324433343444")
	};

	// Test data for invalid DeBruijn streams 
	public final TestData[] INVALID_TESTS = new TestData[] {
			new TestData(3, "01234", "00010020030040110120130140210220230240310320330340413114122123124132133134142143144222322423323424324433343444")
	};
	
	// Test data with duplicates
	public final TestData[] DUPLICATES_TESTS = new TestData[] {
			new TestData(3, "01234", "00010010020030040110120130140210220230240310320330340410420430441112113114122123124132133134142143144222322423323424324433343444")
	};
	
	/*
	 * Loads the data from {@code data} and builds the corresponding 
	 * coverage tree.
	 */
	private Tree<Character> process(TestData data) {
		
		// Convert the alphabet t o character array
		Character[] chars = TestUtils.toObjectArray(data.alphabet);

		Tree<Character> tree = new Tree<Character>(chars, data.sequenceLength);

		DeBruijnStream stream = new DeBruijnStream(data.sequenceLength, data.alphabet.length(), data.sequence);

		// Get the iterator over the data stream and add all
		// sequences that we extract from the stream to the tree
		Iterator<String> itr = stream.iterator();
		while (itr.hasNext()) {
			String perm = itr.next();

			tree.add(TestUtils.toObjectArray(perm));
		}
		
		return tree;
	}
	
	
	/**
	 * Test data streams that do not cover all permutation on the input alphabet
	 */
	@Test
	public void testInvalidData() {

		for (TestData data : INVALID_TESTS) {

			Tree<Character> tree = process(data);

			// If all sequences appeared in De Bruijn the tree should be full.
			assertFalse(tree.isFull());
		}
	}
	
	/**
	 * Test data streams that cover all permutation on the input alphabet
	 * but have duplicates in the input
	 */
	@Test
	public void testDataWithDuplicates() {

		for (TestData data : DUPLICATES_TESTS) {

			Tree<Character> tree = process(data);

			// If all sequences appeared in De Bruijn the tree should be full.
			assertFalse(tree.hasDuplicates());
		}
	}
	
	/**
	 * Test valid data streams
	 */
	@Test
	public void testValidData() {

		for (TestData data : TESTS) {

			Tree<Character> tree = process(data);

			// If all sequences appeared in De Bruijn the tree should be full.
			assertTrue(tree.isFull());

			// We make sure that the De Bruijn stream is optimal without
			// repetitions
			assertFalse(tree.hasDuplicates());
		}
	}
	
	// Holds a data set for a single test of the DeBruijnStream class
	public class TestData {

		// The the alphabet
		String alphabet;

		// The length of a single sequence
		int sequenceLength;

		// The De-Bruijn stream data
		String sequence;

		TestData(int sequenceLength, String alphabet, String sequence) {
			this.alphabet = alphabet;
			this.sequenceLength = sequenceLength;
			this.sequence = sequence;
		}
	}
}
