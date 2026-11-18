/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * function BinaryMatrix() {
 *     @param {integer} row, col
 *     @return {integer}
 *     this.get = function(row, col) {
 *         ...
 *     };
 *
 *     @return {[integer, integer]}
 *     this.dimensions = function() {
 *         ...
 *     };
 * };
 */

class Solution {
    /**
     * @param {BinaryMatrix} binaryMatrix
     * @return {number}
     */
    leftMostColumnWithOne(binaryMatrix) {

        
        const [n, m] = binaryMatrix.dimensions();

        // Starting at the top right -> (0, m - 1)
        let i = 0;
        let j = m - 1;
        
        let leftMostColumnIndex = Infinity;
        while (i < n && j >= 0) {
            if (binaryMatrix.get(i, j) == 1) {
                // record the column 
                leftMostColumnIndex = j;
                j = j - 1;
            } else {
                i = i + 1;
            }
        }
        return leftMostColumnIndex === Infinity ? -1: leftMostColumnIndex;
    }
}
