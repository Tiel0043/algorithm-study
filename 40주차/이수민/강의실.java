import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return Integer.compare(o1[1], o2[1]);
				}
				return Integer.compare(o1[0], o2[0]);
			}
		});

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int cnt = 1;

		for (int i = 0; i < N; i++) {
			if (pq.isEmpty()) {
				pq.offer(arr[i][1]);
				continue;
			} else if (pq.peek() <= arr[i][0]) {
				pq.poll();
			} else if (pq.peek() > arr[i][0]) {
				cnt++;
			}
			pq.offer(arr[i][1]);
		}
		System.out.println(cnt);

	}
}
