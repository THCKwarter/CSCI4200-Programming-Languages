(print "1.2 Palindrome - CSCI4200 - Matthew Johnston")
(print "############################################")

;;; Get string from user
(format t "~%Enter a palindrome:")
(defvar inputString (read))
(setf inputString (write-to-string inputString))
(defvar reverseString (reverse inputString))

;;; Determine if string is a palindrome
(if (equal inputString reverseString)
	(print "That is a palindrome.")
	(print "That is not a palindrome."))