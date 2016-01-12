package com.algorithms.debruijn;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;

public class DeBruijnStream implements Iterable<String> {

	// The number of symbols. For alphabet {0,1,2,3,4,5,6,7,8,9} 
	// alphabetLength is 10
	int alphabetLength;

	// The length of the sequence. Example: For sequenceLength = 4 we 
	// have the following sequences [0000, 0001, 0002 ... 9999]
	int sequenceLength;

	// The actual DeBruijn data
	String sequence;

	/**
	 * Builds a DeBruijnStream with the corresponding alphabet, sequence size
	 * and data.
	 * 
	 * @param sequenceLength
	 *            The length of the sequences we handle (the 'permutations' on
	 *            the alphabet). Example: For sequenceLength = 4 we get the
	 *            sequences [0000, 0001, ... 9999].
	 * @param alphabetLength
	 *            The number of symbols in the alphabet. For alphabet
	 *            {0,1,2,3,4,5,6,7,8,9} alphabetLength is 10; for binary
	 *            alphabet {0,1} alphabetLength is 2
	 * @param sequence
	 *            The De-Bruijn data to handle
	 */
	public DeBruijnStream(int sequenceLength, int alphabetLength, String sequence) {
		this.alphabetLength = alphabetLength;
		this.sequenceLength = sequenceLength;
		this.sequence = sequence;

		if (sequenceLength < 1 || alphabetLength < 1 || sequence == null || sequence.length() < sequenceLength) {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Returns an iterator over the elements in this sequence in proper
	 * sequence.
	 *
	 * <p>
	 * The returned iterator is <a href="#fail-fast"><i>fail-fast</i></a>.
	 *
	 * @return an iterator over the elements in this list in proper sequence
	 */
	public Iterator<String> iterator() {
		return new Itr();
	}

	// Iterator implementation over the De-Bruijn data stream
	private class Itr implements Iterator<String> {

		// index of next element to return
		int cursor;

		// Holds the current permutation
		char[] perm;

		public Itr() {

			cursor = 0;
			perm = new char[sequenceLength];

			// Copy the last <length> characters from the sequence. In
			for (int i = 0; i < sequenceLength; i++) {
				perm[i] = sequence.charAt(sequence.length() - sequenceLength + i);
			}
		}

		public boolean hasNext() {
			
			// Check if we have reached the end of the data stream
			return cursor != sequence.length();
		}

		public String next() {
			String result = new String(perm);

			// Shift the last sequence array by 1 character and add 
			// the next character
			System.arraycopy(perm, 1, perm, 0, sequenceLength - 1);
			perm[sequenceLength - 1] = sequence.charAt(cursor);
			cursor++;

			return result;
		}

		/**
		 * Removing elements is not supported
		 */
		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void forEachRemaining(Consumer<? super String> consumer) {
			Objects.requireNonNull(consumer);

			while (cursor < sequence.length()) {

				System.arraycopy(perm, 1, perm, 0, sequenceLength - 1);
				perm[sequenceLength - 1] = sequence.charAt(cursor);
				cursor++;

				consumer.accept((String) new String(perm));
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(DeBruijnStream.class.getSimpleName());
		sb.append(" [symbol count=");
		sb.append(alphabetLength);
		sb.append(", sequence length=");
		sb.append(sequenceLength);

		if (sequence == null) {
			sb.append(", empty sqeuqnce");
		} else {
			sb.append(", sqeuqnce size=");
			sb.append(sequence.length());
		}

		sb.append(']');

		return sb.toString();
	}

}
