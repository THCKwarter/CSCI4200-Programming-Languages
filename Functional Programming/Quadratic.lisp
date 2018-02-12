(print "1.3 Quadratic Equation - CSCI4200 - Matthew Johnston")
(print "####################################################")

;;; Get quadratic equation coefficients
(format t "~%Enter first (a) coefficient: ")
(defvar inputA (read))
(format t "~%Enter second (b) coefficient: ")
(defvar inputB (read))
(format t "~%Enter third (c) coefficient: ")
(defvar inputC (read))

;;; Evaluate quadratic equation
(defun quadratic (inputA inputB inputC)
  (cond ((= inputA 0) (string "Not a quadratic equation."))
    (t
    (let ((D (- (* inputB inputB) (* 4 inputA inputC))))
      (cond ((= D 0) (concatenate 'string "x = " (write-to-string (/ (+ (- inputB) (sqrt D)) (* 2 inputA)))))
        (t
        (values (print (concatenate 'string "Root 1 is: " (write-to-string (/ (+ (- inputB) (sqrt D)) (* 2 inputA)))))
                (print (concatenate 'string "Root 2 is: " (write-to-string (/ (- (- inputB) (sqrt D)) (* 2 inputA))))))))))))

(quadratic inputA inputB inputC)