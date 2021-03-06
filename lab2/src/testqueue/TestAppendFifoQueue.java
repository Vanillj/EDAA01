package testqueue;

import static org.junit.Assert.*;

import org.junit.Test;

import queue_singlelinkedlist.FifoQueue;

public class TestAppendFifoQueue {
	
	@Test
	public void TwoEmptyQueues() {
		FifoQueue<Integer> q1 = new FifoQueue<>();
		FifoQueue<Integer> q2 = new FifoQueue<>();
		try {
			q1.append(q2);
			fail("should bla bla not work exception bla empty queues identical");
		} catch (Exception error) {
			//can't append identical queues
		}
		assertTrue(q1.size() == 0);
	}

	@Test
	public void OneEmptyQueueAppend() {
		FifoQueue<Integer> q1 = new FifoQueue<>();
		FifoQueue<Integer> q2 = new FifoQueue<>();
		for (int i = 1; i <= 5; i++) {
			q2.offer(i);
		}
		q1.append(q2);
		assertEquals("queue has correct size", q1.size(), 5);
		assertEquals("queue has correct size", q2.size(), 0);
		for (int i = 1; i <= 5; i++) {
			int k = q1.poll();
			assertEquals("poll returns incorrect element", i, k);
		}
		
	}

	@Test
	public void OneQueueAppendEmpty() {
		FifoQueue<Integer> q1 = new FifoQueue<>();
		FifoQueue<Integer> q2 = new FifoQueue<>();
		for (int i = 1; i <= 5; i++) {
			q2.offer(i);
		}
		q2.append(q1);
		assertEquals("queue has correct size", q2.size(), 5);
		assertEquals("queue has correct size", q1.size(), 0);
		for (int i = 1; i <= 5; i++) {
			int k = q2.poll();
			assertEquals("poll returns incorrect element", i, k);
		}
	}

	@Test
	public void TwoQueuesAppend() {
		FifoQueue<Integer> q1 = new FifoQueue<>();
		FifoQueue<Integer> q2 = new FifoQueue<>();

		for (int i = 1; i <= 5; i++) {
			q1.offer(i);
		}
		for (int i = 6; i <= 10; i++) {
			q2.offer(i);
		}

		q1.append(q2);
		assertEquals("queue has correct size", q1.size(), 10);
		assertEquals("queue has correct size", q2.size(), 0);

		for (int i = 1; i <= 10; i++) {
			int k = q1.poll();
			assertEquals("poll returns incorrect element", i, k);
		}
	}

	@Test
	public void AppendSelf() {
		FifoQueue<Integer> q1 = new FifoQueue<>();
		FifoQueue<Integer> q2 = new FifoQueue<>();
		for(int i = 1; i <= 5; i++) { q1.offer(i); }
		try {
			q2.append(q2);
			fail("should bla bla not work exception bla");
			q1.append(q1);
			fail("should bla bla not work exception bla");
		}catch(Exception error) {
			//can't append self
		}
		
		
	}

}
