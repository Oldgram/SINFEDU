def is_palindrome(s):
    """
    pre: `s` est un str
    post: determine iterativement si `s` est un palindrome ou non

    Note : en python, on peut simplement verifier qu'un string est un palindrome en faisant:
    s == s[::-1]
    Mais il ici est demande de le faire de maniere iterative
    """
    if len(s) < 2:
        return True

    for i in range(len(s) // 2):
        if s[i] != s[-i - 1]:
            return False

    return True


# Exemple de test:
if not is_palindrome("kayak"):
    print("Erreur : kayak est un palindrome")
if is_palindrome("yWAcqFGzYtEw"):
    print("Erreur : yWAcqFGzYtEw n'est pas un palindrome")
