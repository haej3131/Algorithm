package study.algo.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Example7 {
	public static void main(String[] args) {

		print(solution(new int[][] { { 5, 3 }, { 11, 5 }, { 13, 3 }, { 3, 5 }, { 6, 1 }, { 1, 3 }, { 8, 6 }, { 7, 2 },
				{ 2, 2 } }));
	}

	/*
	 * 이진트리를 구성하는 노드들의 좌표가 담긴 배열 nodeinfo가 매개변수로 주어질 때, 노드들로 구성된 이진트리를 전위 순회, 후위 순회한
	 * 결과를 2차원 배열에 순서대로 담아 return 하도록 solution 함수를 완성하자.
	 * 
	 * nodeinfo는 이진트리를 구성하는 각 노드의 좌표가 1번 노드부터 순서대로 들어있는 2차원 배열이다. nodeinfo의 길이는 1 이상
	 * 10,000 이하이다. nodeinfo[i] 는 i + 1번 노드의 좌표이며, [x축 좌표, y축 좌표] 순으로 들어있다. 모든 노드의
	 * 좌표 값은 0 이상 100,000 이하인 정수이다. 트리의 깊이가 1,000 이하인 경우만 입력으로 주어진다. 모든 노드의 좌표는 문제에
	 * 주어진 규칙을 따르며, 잘못된 노드 위치가 주어지는 경우는 없다.
	 * 
	 */
	public static int[][] solution(int[][] nodeinfo) {
		int answer[][] = {};
		int len = nodeinfo.length;

		// 주어진 배열의 값들을 노드들의 리스트로 변경 & 노드 값 설정
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		for (int i = 0; i < len; i++) {
			TreeNode node = new TreeNode(nodeinfo[i][0], nodeinfo[i][1], i + 1);
			nodes.add(node);
		}

		// 이진트리 구성을 위해 노드 정렬(Y좌표 내림차순 후 X좌표 오름차순)
		Collections.sort(nodes, (TreeNode o1, TreeNode o2) -> {
			return o1.getY() == o2.getY() ? Integer.compare(o1.getX(), o2.getX())
					: Integer.compare(o2.getY(), o1.getY());
		});

		// 이진트리 생성
		TreeNode root = makeTree(nodes, 0, 100000);
		// 노드 정보 초기화
//		initTree(root);
		// 전위 순회, 후위순회
		answer =  new int[][] { preOrder(root, len), postOrder(root, len) };
		return answer;
	}

	/**
	 * Description : 트리 생성 - 주어진 TreeNode 타입 리스트의 데이터를 기준으로 관계를 설정하여 트리 생성
	 * 
	 * @param nodelist 트리의 노드들의 리스트
	 * @param idx      부모 노드의 인덱스 값
	 * @param prevX    부모 노드 기준 X좌표 최대 값
	 * @return
	 */
	private static TreeNode makeTree(List<TreeNode> nodelist, int idx, int prevX) {
		TreeNode node = nodelist.get(idx); // 노드리스트에서 노드 가져옴
		node.setVisited(true); // 트리 포함 여부 true
		int nextY = node.getY(); // nextY 변수 값 초기화(현재 노드의 Y값)
		int nextIdx = idx; // nextIdx 변수 값 초기화(현재 노드의 인덱스)

		// 현재 노드 이후 인덱스 순회하면서 하위 노드에 해당하는 Y값 설정
		for (int i = idx + 1; i < nodelist.size(); i++) {
			if (nodelist.get(idx).getY() > nodelist.get(i).getY()) {
				nextY = nodelist.get(i).getY();
				nextIdx = i;
				break;
			}
		}

		// 하위 노드들의 인덱스 순회하면서 자식 노드(좌, 우) 재귀적으로 설정
		for (int i = nextIdx; i < nodelist.size(); i++) {
			// 트리에 포함되지 않은 노드 중 하위 노드 Y값(위에서 설정한 nextY)을 가진 경우
			if (!nodelist.get(i).isVisited() && nodelist.get(i).getY() == nextY) {
				// X 값이 현재 노드보다 작고, prevX보다 작은 경우 left 노드 설정
				if (nodelist.get(i).getX() < nodelist.get(idx).getX() && nodelist.get(i).getX() < prevX) {
					node.setLeft(makeTree(nodelist, i, node.getX()));
				}
				// X 값이 현재 노드보다 크고, prevX보다 작은 경우 right 노드 설정
				if (nodelist.get(i).getX() > nodelist.get(idx).getX() && nodelist.get(i).getX() < prevX) {
					node.setRight(makeTree(nodelist, i, prevX));
				}

				// 오른쪽 노드 설정된 경우 더 이상 순회하지 않음
				if (node.getRight() != null) {
					break;
				}
			}
		}

		return node;
	}

	/**
	 * Description : 하위 노드들의 visited 값 false로 초기화
	 * 
	 * @param node 초기화할 트리의 노드
	 */
	private static void initTree(TreeNode node) {
		node.setVisited(false);
		if (node.getLeft() != null) {
			initTree(node.getLeft());
		}
		if (node.getRight() != null) {
			initTree(node.getRight());
		}
	}

	private static int[] preOrder(TreeNode root, int size) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		int[] result = new int[size];
		int i = 0;

		while (result[size - 1] == 0) {
			result[i++] = root.getVal();
			if (root.getRight() != null) {
				stack.push(root.getRight());
			}
			if (root.getLeft() != null) {
				root = root.getLeft();
				continue;
			}
			if (!stack.isEmpty()) {
				root = stack.pop();
			}

			if (stack.isEmpty() && root.getLeft() != null && root.getRight() != null) {
				break;
			}
		}
		return result;
	}

	private static int[] postOrder(TreeNode root, int size) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		int[] result = new int[size];
		int i = size;

		while (result[0] == 0) {
			result[--i] = root.getVal();
			if (root.getLeft() != null) {
				stack.push(root.getLeft());
			}
			if (root.getRight() != null) {
				root = root.getRight();
			} else if (!stack.isEmpty()) {
				root = stack.pop();
			} else {
				break;
			}
		}
		return result;
	}

	public static void print(int[][] result) {
		System.out.print("[");
		boolean first_outer = true;
		for (int[] rarr : result) {
			boolean first = true;
			if (first_outer) {
				System.out.print("[");
				first_outer = false;
			} else {
				System.out.print(", [");
			}
			for (int r : rarr) {
				if (first) {
					System.out.print(r);
					first = false;
				} else {
					System.out.print(", " + r);
				}
			}
			System.out.print("]");
		}
		System.out.print("]");
		System.out.println();
	}

}

class TreeNode {
	private int X;
	private int Y;
	private int val;
	private boolean visited;

	TreeNode left;
	TreeNode right;

	public TreeNode() {
	}

	public TreeNode(int X, int Y, int val) {
		this.X = X;
		this.Y = Y;
		this.val = val;
		visited = false;
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

}