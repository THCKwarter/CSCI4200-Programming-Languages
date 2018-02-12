(print "1.1 Summation - CSCI4200 - Matthew Johnston")
(print "###########################################")

(setq output 0)
;;; Get summation range from user
(format t "~%Enter a number for the lower bound of the range:")
(defvar input1 (read))
(format t "Enter a number for the upper bound of the range:")
(defvar input2 (read))

;;; Calculate sum
(loop for x from input1 to input2
	do(setq output (+ output x)))

;;; Output result of loop
(format t "Result of summation was: ~a" output)