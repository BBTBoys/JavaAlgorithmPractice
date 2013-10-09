package net.adman.flower.service;

import org.springframework.stereotype.Service;

@Service
public class ArrayAlgorithmServiceImpl implements ArrayAlgorithmService {

	@Override
	public int[][] calculateZigZagMatrix(int size) {
		if (size > 1) {
			int[][] dataList = new int[size][size];
			int row = 0;
			int col = 0;
			int maxSize = size * size;
			
			for(int count = 1; count <= maxSize; count++) {	// 들어갈 수 있는 총 갯수만큼 루프 실행
				dataList[row][col] = count;					// 내용을 넣음
				if ((row+col) % 2 == 0 ) {					// row 와 column 의 합이 짝수 일 때 (짝수 일 때는 올라감)
					if (size == (row+1)) {						// 더이상 내려갈 수 없을 때 우측 이동하여 올라감
						col++;
						continue;
					}
					row++;
					col--;
					if (col < 0) {
						col = 0;
					}
				} else {									// row 와 column 의 합이 홀수 일 때 (홀수 일 때는 내려감)
					if (size == (col+1)) {						// 더이상 우측이동이 안 되면 아래로 이동하여 내려감
						row++;
						continue;
					}
					row--;
					col++;
					if (row < 0) {
						row = 0;
					}
				}
			}
			return dataList;
		}
		return null;
	}

}
